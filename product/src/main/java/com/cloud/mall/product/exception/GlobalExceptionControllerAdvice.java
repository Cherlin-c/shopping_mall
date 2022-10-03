package com.cloud.mall.product.exception;

import com.cloud.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        return R.error();

    }
}