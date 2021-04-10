package com.reflect;

import com.showable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: MavenTest0329
 * @description: 在程序运行中，有人给你发一个类，请动态了解这个类，且创建类对象
 * @author: Dasiy
 * @create: 2021-03-29 18:43
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请输入类路径：");
            String path=sc.nextLine();
            System.out.println("待加载的类为："+path);

            Class c=Class.forName(path);

            //获取属性
            String name=c.getName();
            System.out.println(name);

            //获取自定义方法
            Field[] fs=c.getDeclaredFields();//declared  自己声明的方法
            if (fs!=null && fs.length>0){
                for (Field f:fs){
                    String modifier="";//类和成员访问修饰符
                    switch (f.getModifiers()) {
                        case 1:
                            modifier="public";
                            break;
                        case 2:
                            modifier="private";
                            break;
                    }
                    System.out.println(modifier+"\t"+f.getName());
                }
            }


            //获取方法
            Method[] ms=c.getDeclaredMethods();
            if (ms!=null && ms.length>0) {
                for (Method m : ms) {
                    System.out.println(m.getModifiers()+"\t"+m.getReturnType().toString()+"\t"+m.getName());
                }
            }

            //构造函数
            Constructor[] cs=c.getConstructors();
            if (cs!=null  && cs.length>0){
                for (Constructor m:cs){
                    System.out.println(m.getModifiers()+"\t"+m.getName());
                }
            }

            //利用反射完成实例化
            Object o=c.newInstance();//获取无参构造方法
            if (o instanceof showable){
                    showable p=(showable) o;
                    p.show();
            }

            //利用反射调用某个方法
            System.out.println("==============");
            if (ms!=null  && ms.length>0){
                for (Method m:ms){
                    if (m.getName().startsWith("sh")){
                        //调用此方法 show  有两个参数；第一个是实例   第二个是参数数组
                        m.invoke(o);
                    }
                }
            }

            Map<String,String>  pMap=new HashMap<String, String>();
            pMap.put("name","张三");
            pMap.put("age","30");
            Object oo=setValues(pMap,c);
            System.out.println(oo.toString());
        }


    }

    public static Object setValues(Map<String,String> map,Class cls) throws Exception {
        Object o=null;
        o=cls.newInstance();
        Method[] ms=cls.getDeclaredMethods();
        if (ms!=null  && ms.length>0){
            for (Method m:ms){
                //只有setXXX才能激活
                if (m.getName().startsWith("set")){
                    String mName =m.getName();
                    String fName=mName.substring(3).toLowerCase();//toLowerCase() 将字符串转换为小写
                    String values=map.get(fName);
                    if ("Interger".equalsIgnoreCase(m.getParameterTypes()[0].getTypeName())   || "int".equalsIgnoreCase(m.getParameterTypes()[0].getTypeName())){
                       m.invoke(o,Integer.parseInt(values));//动态的传入参数
                    }else{
                        m.invoke(o,values);
                    }
                }
            }
        }
        return  o;
    }

}
