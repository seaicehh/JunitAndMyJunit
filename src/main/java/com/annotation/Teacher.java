package com.annotation;

/**
 * @program: MavenTest0329
 * @description:
 * @author: Dasiy
 * @create: 2021-03-29 21:04
 */
@MyHelloWorld(name = "a",ins = {"111"})
public class Teacher {
    @MyHelloWorld(name = "a",ins = {"111"})
    private String name;

    @MyHelloWorld(name = "a",ins = {"111"})
    public void show(@MyHelloWorld(name = "a",ins = {"111"}) String s){

    }
}
