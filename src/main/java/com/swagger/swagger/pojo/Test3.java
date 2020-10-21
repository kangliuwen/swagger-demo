package com.swagger.swagger.pojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *
 *@description:
 *@author: klw
 *@time: 2020-10-19 17:41
 *
 */
public class Test3 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.swagger.swagger.pojo.UserView");

        //调用无参构造器
        UserView instance = (UserView)c1.newInstance();
        System.out.println(instance);

        //通过构造器创建对象
        Constructor construct = c1.getConstructor(String.class,String.class);
        UserView userView = (UserView)construct.newInstance("康刘文", "22");
        System.out.println(userView);

        //通过反射调用方法
        Method method = c1.getDeclaredMethod("printUser", String.class);
        method.setAccessible(true);//关闭安全监测
        method.invoke(userView, "康康");

        //通过反射使用属性
        Field userName = c1.getDeclaredField("userName");
        userName.setAccessible(true);
        userName.set(userView,"张三");
        System.out.println(userView.getUserName());


    }
}
