package com.sinochem.fintech.aop;

import com.alibaba.fastjson.JSON;
import com.sinochem.fintech.util.LocalDateUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.UUID;

/**
 * @Author: heshouyou
 * @Description  请求日志记录
 * @Date Created in 2018/12/6 14:02
 */
@Slf4j
@Aspect
@Component
@EnableAspectJAutoProxy
public class RequestLogAspect {

    @Pointcut("execution(* com.sinochem.fintech.rest.*Controller.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void requestLog(JoinPoint joinPoint){
        //请求方式，请求时间，请求参数
        String currentDateStr = LocalDateUtils.getCurrentDateStr();
        //请求唯一编号
//        String uuid = UUID.randomUUID().toString().replace("-","");
        Object[] args = joinPoint.getArgs();
        StringBuilder builder = new StringBuilder();
        for (Object o:args) {
            if (o instanceof BindingResult) {
                continue;
            }
            String argsJson = JSON.toJSONString(o);
            builder.append(argsJson).append(" | ");
        }

        log.info("===================================接受到请求=========================================");
        log.info("进入方法时间： {}" , currentDateStr);
        log.info("方法参数： {}" , builder.toString());
        log.info("===================================打印日志完毕=========================================");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void reponseLog(Object result){
        //请求方式，请求时间，请求参数
        String currentDateStr = LocalDateUtils.getCurrentDateStr();
        //请求唯一编号
//        String uuid = UUID.randomUUID().toString().replace("-","");
        String argsJson = JSON.toJSONString(result);
        log.info("===================================开始响应=========================================");
        log.info("请求响应时间： {}" , currentDateStr);
        log.info("返回结果： {}" , argsJson);
        log.info("===================================打印日志完毕=========================================");
    }

}
