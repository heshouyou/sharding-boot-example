package com.sinochem.fintech.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: heshouyou
 * @Description  自定义异常
 * @Date Created in 2018/12/6 15:46
 */
@Data
@Builder
public class BaseException extends RuntimeException{

    private Integer status;

    private String message;
}
