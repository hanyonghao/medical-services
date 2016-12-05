package com.hyh.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContext;

/**
 * 全局变量
 * @author HAO
 */
public class Global {
	
	//保存全局资源
	private static ServletContext content = null;
	
	//保存外部配置文件
	private static Properties properties = null;

	/**
	 * 设置全局资源
	 * @param content
	 */
	public static void setServletContent(ServletContext content){
		Global.content = content;
	}
	
	/**
	 * 设置配置
	 * @param key
	 * @param value
	 */
	public static void setConfig(String key , String value){
		content.setAttribute(key, value);
	}
	
	/**
	 * 获取文件真实路径
	 * @param fileName
	 * @return
	 */
	public static String getRealPath(String fileName){
		return content.getRealPath(fileName);
	}
	
	/**
	 * 获取配置
	 * @param key 
	 * @return
	 */
	public static String getConfig(String key) {
		String value = (String) content.getAttribute(key);
		if (value == null){
			if((properties = getProperties()) != null){
				value = properties.getProperty(key);
				content.setAttribute(key, value);
			}
		}
		return value;
	}
	
	/**
	 * 获取配置文件
	 * @return
	 */
	private static Properties getProperties(){
		if(properties == null){
			try{
				InputStream is = content.getResourceAsStream("Conf/config.properties");
				properties = new Properties();
				properties.load(is);
			} catch (Exception e){
                System.out.println("异常：如果无法加载配置文件请复制到src内，即项目的classes内");
                ClassLoader classLoader = content.getClassLoader();
                URL resource = classLoader.getResource("config.properties");
                properties = new Properties();
                try {
                    properties.load(resource.openStream());
                } catch (Exception e1) {
                    System.out.println("异常：该配置文件有错误。");
                    e1.printStackTrace();
                }
			}
		}
		return properties;
	}
}
