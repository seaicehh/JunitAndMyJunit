package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: MavenTest0329
 * @description:
 * @author: Dasiy
 * @create: 2021-03-29 21:09
 */
@Target(value = {ElementType.TYPE})
//这个注解什么时候保留
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DBConnection {
    //连接数据库的属性
    public String url();
    public  String driverClass();
    public  String user() default "root";
    public String pwd() default "root";
}
