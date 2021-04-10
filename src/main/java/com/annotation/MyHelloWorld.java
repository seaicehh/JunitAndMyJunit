package com.annotation;

import java.lang.annotation.*;

/**
 * @program: MavenTest0329
 * @description:自定义注解
 * target:表明这个注解可以加在类的哪个地方
 * value={}    表示组target注解的属性   value赋了一个数组的值
 * retention:source 只在源码存在    class  只在源码，字节码存在       runtime  一直到运行时都存在
 * @author: Dasiy
 * @create: 2021-03-29 20:38
 */
@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})//类 属性 方法  参数
//这个注解什么时候保留
@Retention(value = RetentionPolicy.RUNTIME)
@Documented//生成的  java doc文档是否保留这个注解
@Inherited   //子类是否可以继承父类的注解
public @interface MyHelloWorld {//空注解
    public  String name();//之后使用这个注解必须要有这个属性值   name
    public  int age() default 20;//带默认值

    public  String[]  ins();

}
