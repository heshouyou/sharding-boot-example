package com.sinochem.fintech.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;

/**
 * @Author: heshouyou
 * @Description  controller架构
 * @Date Created in 2018/12/6 10:07
 */
@Slf4j
public class BaseController<T extends BaseService,E> {

    public BaseResponse validateField(BindingResult bindingResult){
        log.info("start processing validateField method ");
        StringBuilder builder = new StringBuilder("校验错误字段：");
//        BaseResponse response = BaseResponse.builder().build();
        BaseResponse response = new BaseResponse();
        if (bindingResult.hasErrors()) {
            String string = bindingResult.getFieldErrors().stream().map(fieldError -> builder.append(fieldError).append(" ; ")).toString();
            log.info("validate error field is ",string);
            response.setStatus(500);
            response.setMessage(string);
        }

        return response;
    }
}
