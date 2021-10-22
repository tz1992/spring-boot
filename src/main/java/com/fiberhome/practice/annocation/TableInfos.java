package com.fiberhome.practice.annocation;



import com.fiberhome.practice.service.BaseService;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface TableInfos {
	/**
	 * 查询数据库所用到的类
	 */
	Class<?> serviceClass() default BaseService.class;
}
