package com.hyh.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * 映射表
 * @author HAO
 */
@Target(ElementType.TYPE)   //接口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME)   //注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface EntityTable {
	String value();
}
