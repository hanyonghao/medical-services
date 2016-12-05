package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;

import com.hyh.entity.UserEntity;
import com.hyh.service.UserService;
import com.hyh.util.GUIDUtil;
import com.hyh.util.TextUtil;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping("User")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

    private String loginName;
    private String name;
    private String password;
    private String passwordAgain;

    public void login() throws ServletException, IOException {
        display("User/login.jsp");
	}

    public void register() throws ServletException, IOException {
        display("User/register.jsp");
    }

    public void saveRegister() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!TextUtil.isEmpty(loginName) && !TextUtil.isEmpty(name) && !TextUtil.isEmpty(password) && !TextUtil.isEmpty(passwordAgain)){
            if(password.equals(passwordAgain)){
                UserEntity user = new UserEntity();
                user.setName(name);
                user.setLoginName(loginName);
                user.setPassword(password);
                if(userService.saveRegister(user)){
                    map.put("status", true);
                    map.put("msg", "注册成功");
                }else{
                    map.put("status", false);
                    map.put("msg", "注册失败");
                }
            }else {
                map.put("status", false);
                map.put("msg", "两次密码不相同");
            }
        }else{
            map.put("status", false);
            map.put("msg", "填写信息不能为空！");
        }

        returnJSON(map);
    }

    public void checkLogin() throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!TextUtil.isEmpty(loginName) && !TextUtil.isEmpty(password)){
            UserEntity user = new UserEntity();
            user.setLoginName(loginName);
            user.setPassword(password);

            UserEntity relUser = userService.checkLogin(user);
            if(relUser != null){
                map.put("status", true);
                map.put("msg", "登录成功");
                session.setAttribute("user",relUser);
            }else{
                map.put("status", false);
                map.put("msg", "登录失败");
            }
        }else{
            map.put("status", false);
            map.put("msg", "填写信息不能为空！");
        }

        returnJSON(map);
    }

    /**
     * 异步图片上传
     * @throws ServletException
     * @throws IOException
     */
    public void ajaxUploadFile() throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        String realDir = request.getSession().getServletContext().getRealPath("");
//        String contextpath = request.getContextPath();
//        String basePath = request.getScheme() + "://"
//        + request.getServerName() + ":" + request.getServerPort()
//        + contextpath + "/";
        System.out.println(realDir);
        if(hasLogin()){
            try {
                String filePath = "Uploads/User";
                String realPath = realDir+"\\"+filePath;
                //判断路径是否存在，不存在则创建
                File dir = new File(realPath);
                if(!dir.isDirectory()){
                    dir.mkdir();
                }

                if(ServletFileUpload.isMultipartContent(request)){

                    DiskFileItemFactory dff = new DiskFileItemFactory();
                    dff.setRepository(dir);
                    dff.setSizeThreshold(1024000);
                    ServletFileUpload sfu = new ServletFileUpload(dff);
                    FileItemIterator fii = null;
                    fii = sfu.getItemIterator(request);
                    String title = "";   //图片标题
                    String url = "";    //图片地址
                    String fileName = "";
                    String mes="上传成功！";
                    String realFileName="";
                    while(fii.hasNext()){
                        FileItemStream fis = fii.next();

                        try{
                            if(!fis.isFormField() && fis.getName().length()>0){
                                fileName = fis.getName();
                                Pattern reg=Pattern.compile("[.]jpg|png|jpeg|gif$");
                                Matcher matcher=reg.matcher(fileName);
                                if(!matcher.find()) {
                                    mes = "文件类型不允许！";
                                    break;
                                }
                                realFileName = new Date().getTime()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
                                url = realPath+"\\"+realFileName;

                                BufferedInputStream in = new BufferedInputStream(fis.openStream());//获得文件输入流
                                FileOutputStream a = new FileOutputStream(new File(url));
                                BufferedOutputStream output = new BufferedOutputStream(a);
                                Streams.copy(in, output, true);//开始把文件写到你指定的上传文件夹
                            }else{
                                String fname = fis.getFieldName();

                                if(fname.indexOf("pictitle")!=-1){
                                    BufferedInputStream in = new BufferedInputStream(fis.openStream());
                                    byte c [] = new byte[10];
                                    int n = 0;
                                    while((n=in.read(c))!=-1){
                                        title = new String(c,0,n);
                                        break;
                                    }
                                }
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }

                    /** 更新用户头像 **/
                    UserEntity user = (UserEntity) session.getAttribute("user");
                    user.setHead("/"+filePath+"/"+realFileName);
                    Map<String, Object> map = new HashMap<String, Object>();
                    response.setStatus(200);
                    if(userService.updateUser(user)){
                        session.setAttribute("user",user);
                        map.put("src", "/"+filePath+"/"+realFileName);
                        map.put("status", true);
                        map.put("msg", mes);
                    }else{
                        map.put("status", false);
                        map.put("msg", "更新头像失败");
                    }
                    returnJSON(map);
                }else{
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("status", false);
                    map.put("msg", "上传失败");
                    returnJSON(map);
                }
            }catch(Exception ee) {
                ee.printStackTrace();
            }
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("status", false);
            map.put("msg", "失败：未完成登陆");
            returnJSON(map);
        }
    }

    private boolean hasLogin(){
        Object user = session.getAttribute("user");
        if(user != null){
            return true;
        }
        return false;
    }
}
