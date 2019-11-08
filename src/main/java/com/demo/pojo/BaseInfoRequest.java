package com.demo.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * create by liu_zhang on 2019/10/22 17:44.
 */
@Data
@Api(value = "基本请求参数")
public class BaseInfoRequest {

    @ApiParam(name = "version", value = "版本号", required = false, defaultValue = "1.0", allowableValues = "1.0")
    @Pattern(regexp = "1.0", message = "要求：version must equels 1.0")
    private String version;

    @ApiParam(name = "format", value = "格式", required = false, defaultValue = "json", allowableValues = "json,jsonp")
    @NotNull
    private String format;
}
