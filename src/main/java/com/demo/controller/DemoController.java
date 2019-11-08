package com.demo.controller;

import com.demo.pojo.GoodDto;
import com.demo.pojo.GoodInfo;
import com.demo.pojo.User;
import com.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * create by liu_zhang on 2019/10/22 16:27.
 */
@RestController
@RequestMapping("test")
@Api(value = "controller:接口名称", tags = "商业controller", description = "controller:接口描述信息")
public class DemoController {

    @Autowired(required = false)
    private UserService userService;

    @PostMapping("1")
    @ApiOperation(value = "test1:value", httpMethod = "POST", response = String.class)
    public GoodDto test1(@RequestBody @Valid @ApiParam(value = "info", required = true) GoodInfo info) {

        System.out.println(info.toString());
        System.out.println(info.getVersion());
        System.out.println(info.getFormat());

        GoodDto goodDto = new GoodDto();
        goodDto.setId(1);
        goodDto.setName("水果");
        return goodDto;
    }
    @GetMapping("2/{name}")
    @ApiOperation(value = "test2:value", httpMethod = "GET", response = String.class)
    public GoodDto test2(@PathVariable("name") @ApiParam(value = "name", required = true) String name) {


        System.out.println(name);
        GoodDto goodDto = new GoodDto();
        goodDto.setId(2);
        goodDto.setName("肉");
        return goodDto;
    }

    @RequestMapping("user")
    public User user(){
        return userService.getUser();
    }
}