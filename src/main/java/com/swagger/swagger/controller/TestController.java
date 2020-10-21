package com.swagger.swagger.controller;

import com.swagger.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 *@description:
 *@author: klw
 *@time: 2020-10-14 11:17
 *
 */
@RestController
@Api(tags={"用户接口","的几点见覅"})
public class TestController {

    @GetMapping(value = "/index")
    public String index(){

        return "hello";
    }
    //只要我们接口的返回值中存在实体类，他就会被扫描到swagger中
    @ApiOperation(value = "接口说明注释", notes = "接口详细说明注释")
    @PostMapping("/getUser")
    public User getUser(@ApiParam(value = "新增用户入参", required = true)  String params){
        return new User("测试用户","33");
    }

    @ApiOperation(value = "接口说明注释", notes = "接口详细说明注释")
    @PostMapping("/getUser2")
    public String getUser2(@ApiParam(value = "用户名称", required = true) String username,@ApiParam("用户年龄") String userage){
        return "jjjjj"+username+userage;
    }

    @ApiOperation(value = "接口说明注释", notes = "接口详细说明注释")
    @PostMapping("/getUser3")
    public User getUser3(@ApiParam(value = "用户", required = true) User user){
        return new User(user.userName,"33");
    }

}
