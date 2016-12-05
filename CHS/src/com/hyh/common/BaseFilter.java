package com.hyh.common;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.config.Global;
import com.hyh.util.ClassUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseFilter implements Filter {
	
	private List<Class<?>> allClass; // 所有Controller列表
	private Map<String,Class<?>> ConMap = new HashMap<String,Class<?>>(); //操作器映射
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("过滤器启动...");
		System.out.println("项目路径："+config.getServletContext().getRealPath(""));
		Global.setServletContent(config.getServletContext()); // 配置全局资源
		allClass = ClassUtil.getClasses(Global.getConfig("app.controller"));
		for (Class<?> clazz : allClass) { //保存控制器映射表
			String key = clazz.getAnnotation(RequestMapping.class).value();
			ConMap.put(key, clazz);
		}
		/** 全局变量设置 **/
		Global.setConfig("appRoot", config.getServletContext().getContextPath());
		Global.setConfig("appView", Global.getConfig("appRoot") + Global.getConfig("app.view"));
		Global.setConfig("appPublic", Global.getConfig("appRoot") + Global.getConfig("app.public"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		/** 设置常量 **/
		resp.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		req.setAttribute("appPath", Global.getConfig("appView"));
		req.setAttribute("appRoot", Global.getConfig("appRoot"));
		req.setAttribute("appPublic", Global.getConfig("appPublic"));
		
		/** URI解析 **/
		String uri = req.getRequestURI();
		String root = Global.getConfig("appRoot") + "/";
		uri = uri.substring(root.length(), uri.length());
		int len = uri.length();
        try {
			if(len > 0){ // 如果没有请求资源
				if(uri.indexOf("/") == -1 && uri.indexOf(".") == -1){ //如果没有请求方法则默认访问index
					Class<?> ConClass = ConMap.get(uri);
					if(ConClass != null){ //如果没有对应的控制器
                        autoFill(ConClass, Global.getConfig("app.defaultMethod"), req, resp);
					}else{
						exceptionHandling(req,resp,"访问资源不存在");
					}
				}else if(uri.indexOf(".") == -1){ //忽略访问静态资源的请求
					String[] uriList = uri.split(Global.getConfig("app.split"));
					Class<?> ConClass = ConMap.get(uriList[0]);
					if(ConClass != null){ //如果没有对应的控制器
                        autoFill(ConClass, uriList[1], req, resp);
					}else{
						exceptionHandling(req,resp,"访问资源不存在");
					}
				}else if(uri.indexOf(".jsp") != -1){ //不允许直接访问jsp
					exceptionHandling(req,resp,"访问资源为非法资源");
				}else{ //允许访问静态资源的请求
					chain.doFilter(request, response); //放行
				}
			}else{
				defaultHandling(req,resp);
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"映射方法不存在");
		} catch (SecurityException e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"私有方法无权访问");
		} catch (InstantiationException e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"对象实例化失败");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"没有找到该属性");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"私有对象无权实例化");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"传递参数异常");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"方法执行异常");
		} catch (Exception e) {
			e.printStackTrace();
			exceptionHandling(req,resp,"其他异常");
		}
	}

	/**
	 * 异常处理
	 * @param req
	 * @param resp
	 */
	private void exceptionHandling(HttpServletRequest req, HttpServletResponse resp , String exceptionInfo) throws ServletException, IOException {
		System.out.println(exceptionInfo);
		resp.setStatus(404);
	}

	/**
	 * 默认处理
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
     * @throws NoSuchFieldException
     */
	private void defaultHandling(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException{
		Class<?> clazz = ConMap.get(Global.getConfig("app.defaultController"));
        autoFill(clazz, Global.getConfig("app.defaultMethod"), req, resp);
	}

	/**
	 * 自动填充并执行 request,response
	 * @param ConClass
	 * @param methodName
	 * @param req
	 * @param resp
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
	private void autoFill(Class<?> ConClass, String methodName, HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		
		Object obj = ConClass.newInstance(); //实例化
		
		/**填充父类属性**/
		Field reqf = ConClass.getSuperclass().getDeclaredField("request"); //获取属性
		Field respf = ConClass.getSuperclass().getDeclaredField("response"); //获取属性
		Field sessionf = ConClass.getSuperclass().getDeclaredField("session"); //获取属性
		reqf.set(obj, req); //填充
		respf.set(obj, resp); //填充
		sessionf.set(obj, req.getSession()); //填充
		
		/**填充子类属性**/
		autoInstantiation(obj);

		/**填充request参数到Controller属性**/
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entries : parameterMap.entrySet()){
            String[] values = entries.getValue();
            String key = entries.getKey();
            try{
                if(key.indexOf(".") == -1){ //如果是普通参数
                    Field field = ConClass.getDeclaredField(key);
                    if(field != null){
                        field.setAccessible(true); //设置些属性是可以访问的
                        if(values.length <= 1){
                            field.set(obj,values[0]);
                        }else{
                            field.set(obj,values);
                        }
                    }
                }else{//如果是反射类
                    String[] entity = key.split("\\.");
                    Field field = ConClass.getDeclaredField(entity[0]);
                    field.setAccessible(true); //设置些属性是可以访问的
                    if(field.get(obj) == null){
                        field.set(obj,field.getType().newInstance());
                    }
                    Object entityObj = field.get(obj);
                    //注册一个转换器，转换日期类型
                    ConvertUtils.register(new Converter() {
                        @Override
                        public Object convert(Class clazz, Object obj) {
                            if(clazz == Date.class){
                                try{
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    return sdf.parse((String) obj);
                                }catch (Exception e){
                                    try {
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        return sdf.parse((String) obj);
                                    } catch (ParseException e1) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                            return null;
                        }
                    }, Date.class);
                    if(values.length <= 1){
                        BeanUtils.setProperty(entityObj, entity[1], values[0]);
                    }else{
                        BeanUtils.setProperty(entityObj, entity[1], values);
                    }
                }

            }catch (Exception e){
                System.out.println(key+"属性不存在");
            }
        }

        /**映射方法执行**/
		Method method = ConClass.getMethod(methodName);
		method.invoke(obj); //执行方法
	}
	
	/**
	 * 自动实例化子类属性
	 * @param obj
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private void autoInstantiation(Object obj) throws InstantiationException, IllegalAccessException{
		Field[] fieldList = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fieldList.length; i++) {
			Field field = fieldList[i];
			if(field.getAnnotation(Autowired.class) != null){ //如果有自动填充的注解则自动实例化对象
				Object fobj = field.getType().newInstance(); //填充
				field.setAccessible(true); //设置些属性是可以访问的  
				field.set(obj, fobj);
				/**递归填充**/
				autoInstantiation(fobj);
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("过滤器消亡...");
	}
}
