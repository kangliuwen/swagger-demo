package com.swagger.swagger.pojo;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 *
 *@description:
 *@author: klw
 *@time: 2020-10-19 18:34
 *
 */
public class Test5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //通过反射获取注解
        Class c1 = Class.forName("com.swagger.swagger.pojo.UserView");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("==="+annotation);
        }
        //获得注解的值
        kangTable annotation = (kangTable)c1.getAnnotation(kangTable.class);
        System.out.println(annotation.value());

        kangFiled kangFiled = (kangFiled)c1.getAnnotation(kangFiled.class);
        System.out.println(kangFiled);

        //获得指定的注解值
        Field userName = c1.getDeclaredField("userName");
        kangFiled kangFiled1 = (kangFiled)userName.getAnnotation(kangFiled.class);
        System.out.println(kangFiled1.column());
        System.out.println(kangFiled1.length());
        System.out.println(kangFiled1.type());

        Class c2 = Class.forName("com.swagger.swagger.controller.TestController");
        Annotation[] annotations1 = c2.getAnnotations();
        for (Annotation annotation1 : annotations1) {
            System.out.println("AAAA:"+annotation1);
        }
        Method getUser = c2.getMethod("getUser", String.class);
        Annotation[] annotations2 = getUser.getAnnotations();
        for (Annotation annotation1 : annotations2) {
            System.out.println("BBB:"+annotation1);
            if(annotation1 instanceof io.swagger.annotations.ApiOperation){
                ApiOperation a = (ApiOperation)annotation1;
                System.out.println("ApiOperation:"+a.value()+a.notes());
            }else  if(annotation1 instanceof org.springframework.web.bind.annotation.PostMapping){
                PostMapping a = (PostMapping)annotation1;
                System.out.println("PostMapping:"+a.name());
            }
        }

    }
}
