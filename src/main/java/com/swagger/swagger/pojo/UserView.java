package com.swagger.swagger.pojo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *@description:
 *@author: klw
 *@time: 2020-10-19 17:36
 *
 */
@kangTable("db_userview")
public class UserView {

    @kangFiled(column = "db_username",length = 3,type = "varchar")
    public String userName;
    @kangFiled(column = "db_userid",type = "varchar",length = 2)
    public String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserView(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public UserView() {
    }

    @Override
    public String toString() {
        return "UserView{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    private void printUser(String userName){
        System.out.println("this is user private method!userName:"+userName);
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface kangTable{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface kangFiled{
    String column();
    String type();
    int length();
}