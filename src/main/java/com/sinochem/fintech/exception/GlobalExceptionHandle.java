package com.sinochem.fintech.exception;

import com.sinochem.fintech.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2018/12/6 16:12
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse handleException(Exception e){
        log.error("发生全局异常：{}" ,e);
        BaseResponse response = new BaseResponse();
        response.setStatus(999);
        response.setMessage("全局异常 —— " + e);
        return response;
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse handleBaseException(BaseException e){
        log.error("发生自定义异常：{}" ,e.getMessage());
        BaseResponse response = new BaseResponse();
        response.setStatus(999);
        response.setMessage("z自定义异常 —— " + e.getMessage());
        return response;
    }
}
