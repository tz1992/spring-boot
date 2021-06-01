package com.fiberhome.practice.annocation;



import com.fiberhome.practice.service.BaseService;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface TableInfos {
	/**
	 * 访问数据源
	 */
	String title() default ""; 
	
	/**
	 * 访问主键名
	 */
	String id() default "";
	
	/**
	 * 访问主键别名
	 */
	String idVal() default "";
	/**
	 * 查询数据库所用到的类
	 */
	Class<?> serviceClass() default BaseService.class;
}
