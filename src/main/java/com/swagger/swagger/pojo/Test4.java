package com.swagger.swagger.pojo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *@description:
 *@author: klw
 *@time: 2020-10-19 18:05
 *
 */
public class Test4 {

    //普通调用
    public static void test1(){

        UserView userView = new UserView();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            userView.getUserName();
        }
        long end = System.currentTimeMillis();
        System.out.println("普通方式调用10亿次，需要多久呢："+(end-begin)+"ms");
    }
    //反射调用
    public static void test2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class c1 = Class.forName("com.swagger.swagger.pojo.UserView");
        UserView userView = (UserView)c1.newInstance();
        Method getUserName = c1.getDeclaredMethod("getUserName",null);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            //userView.getUserName();
            getUserName.invoke(userView,null);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射调用10亿次，需要多久呢："+(end-begin)+"ms");
    }
    //关闭安全监测调用
    public static void test3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class c1 = Class.forName("com.swagger.swagger.pojo.UserView");
        Object userView = c1.newInstance();
        Method getUserName = c1.getDeclaredMethod("getUserName",null);
        getUserName.setAccessible(true);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            //userView.getUserName();
            getUserName.invoke(userView,null);
        }
        long end = System.currentTimeMillis();
        System.out.println("关闭安全监测调用10亿次，需要多久呢："+(end-begin)+"ms");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //test1();
        //test2();
        test3();
    }
}
