package com.demo.pojo;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 商品请求相关
 * create by liu_zhang on 2019/10/22 17:53.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodInfo extends BaseInfoRequest {

    @ApiParam(name = "goodType", value = "商品类型", required = true)
    @NotNull
    private String goodType;
}
