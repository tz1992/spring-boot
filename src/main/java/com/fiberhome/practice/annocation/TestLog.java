package com.fiberhome.practice.annocation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface TestLog {
    /**
     * 操作数据类型，1：居民  2：企业  3：个体户
     */
    String dataType() default "";

    /**
     * 操作数据类型，各个类型的子表
     */
    String dataChildrenType() default "";

    /**
     * 操作数据类型，1：新增  2：修改  3：删除
     */
    String operatorType() default "";

    /**
     * 是否删除主表
     */
    boolean deleteMaster() default false;

    /**
     * 是否需要单独表名
     */
    boolean needTableName() default false;

    /**
     * 操作数据库表名
     */
    String tableName() default "";



    /**
     * 查询需要的关键字段
     */
    String key() default "";
}
