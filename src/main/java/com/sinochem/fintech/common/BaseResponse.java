package com.sinochem.fintech.common;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Author: heshouyou
 * @Description  公共返回结果
 * @Date Created in 2018/12/6 10:30
 */
@Data
//@Builder
public class BaseResponse {

    private Integer status = 200;

    private String message;

    private Object data;
}
