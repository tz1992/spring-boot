package com.fiberhome.practice.annocation;


import java.lang.annotation.*;

/**
 * 自定义导出Excel数据注解
 * 
 * @author ruoyi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface Excel
{
    /**
     * 导出到Excel中的名字.
     */
    public abstract String name() default "";
    /**
     * 字典值
     */
    public abstract String value() default "";

    /**
     * 字典类型代码
     */
    public abstract String prompt() default "";

    /**
     * 是否必填
     */
    public abstract boolean required() default false;


    public abstract int col() default 0;

    /**
     * 设置只能选择不能输入的列内容.
     */
    public abstract String[] combo() default {};

    /**
     * 是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
     */
    public abstract boolean isExport() default true;
}
