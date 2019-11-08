package com.demo.pojo;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 商品相关
 * create by liu_zhang on 2019/10/22 17:54.
 */
@Data
public class GoodDto {

    @ApiParam(name = "id", value = "商品id")
    private long id;

    @ApiParam(name = "name", value = "商品名称")
    private String name;

}
