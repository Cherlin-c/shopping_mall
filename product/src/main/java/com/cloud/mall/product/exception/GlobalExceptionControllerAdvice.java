package com.cloud.mall.product.exception;

import com.cloud.mall.common.exception.RRException;
import com.cloud.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author : scl
 * @date :  2022/10/2
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.cloud.mall.product.controller")
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handValidException(MethodArgumentNotValidException e) {
        log.error("异常处理 = {} , 类型 = {}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String,String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(RRException.VAILD_EXCEPTION.getCode(), RRException.VAILD_EXCEPTION.getMsg()).put("data",errorMap);

    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        return R.error(RRException.UNKNOW_EXCEPTION.getCode(), RRException.UNKNOW_EXCEPTION.getMsg());
    }
}