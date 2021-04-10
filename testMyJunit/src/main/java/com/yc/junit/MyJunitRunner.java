package com.yc.junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MavenTest0329
 * @description:
 * @author: Dasiy
 * @create: 2021-03-31 20:43
 */
public class MyJunitRunner {
    public static void main(String[] args) throws Exception {
        //没有idea插件  所以先做类加载
        Class cls=Class.forName("com.yc.MyCalculatorTest");
        //1.获取这个类中的所有方法
        Method[] ms=cls.getDeclaredMethods();
        List<Method> testMethods=new ArrayList<Method>();
        Method beforeMethod=null;
        Method aftherMethod=null;
        Method beforeClassMethod=null;
        Method afterClassMethod=null;

        //2.循环这些方法  判断哪些上面加了注解
        for (Method m:ms){
            //3.将这些方法分别存好    @Test对应的方法有多个  存到一个集合中   其他注解对应的方法只有一个直接存
            if (m.isAnnotationPresent(MyTest.class)){
                testMethods.add(m);
            }
            if (m.isAnnotationPresent(MyBefore.class)){
                beforeMethod=m;
            }
            if (m.isAnnotationPresent(MyAfter.class)){
                aftherMethod=m;
            }
            if (m.isAnnotationPresent(MyBeforeClass.class)){
                beforeClassMethod=m;
            }
            if (m.isAnnotationPresent(MyAfterClass.class)){
                afterClassMethod=m;
            }
        }

        //4.按junit的运行生命周期来调用
        /*
        * beforeClass
        * before
        * add测试
        * after
        * before
        * sub测试
        * after
        * afterclass
        * */

        if (testMethods==null  ||testMethods.size()<=0){
            throw new RuntimeException("没有要测试的方法");
        }
        Object o=cls.newInstance();//实例化  测试类
        beforeClassMethod.invoke(o,null);
        for (Method m:testMethods){
            if (beforeMethod  !=null){
                beforeMethod.invoke(o,null);
            }
            m.invoke(o,null);//测试方法
            if (aftherMethod  !=null){
                aftherMethod.invoke(o,null);
            }
        }
        afterClassMethod.invoke(o,null);

    }
}
