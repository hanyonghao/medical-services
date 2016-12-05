package com.hyh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文本工具
 * 
 * @author HAO
 */
public class TextUtil {
	
	public static final char UNDERLINE = '_'; //下划线

	/**
	 * 驼峰式转下划线
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 下划线转驼峰式
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == UNDERLINE) {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 验证字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		boolean flag = true;
		if(str != null && str.length() > 0){
			flag = false;
		}
		return flag;
	}

	public static Date StringToDate(String date, SimpleDateFormat sdf){
        if(!isEmpty(date)){
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public static String DateToString(Date date, SimpleDateFormat sdf){
		if(date != null){
			return sdf.format(date);
		}
		return null;
	}
}
