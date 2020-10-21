package com.swagger.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.lang.annotation.*;

/**
 *
 *@description:
 *@author: klw
 *@time: 2020-10-14 14:52
 *
 */
@ApiModel(value = "com.swagger.swagger.pojo.User", description = "用户实体类")
public class User  extends Test{
    @ApiModelProperty(value = "用户姓名")
    public String userName;
    @ApiModelProperty(value = "用户年龄")
    public String userage;
    public User(String userName, String userage) {
        this.userName = userName;
        this.userage = userage;
    }
    private String privateName;
    private User(String privateName){
        this.privateName = privateName;
    }
    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @klwAnnotation(name = "klw so good",tags = {"football","hibo","java"})
    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    private String getPrivateName(){
        System.out.println(privateName);
        return privateName;
    }

}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface klwAnnotation{

    String name() default "klw has a big dick";
    int age() default 18;
    String[] tags();

}
