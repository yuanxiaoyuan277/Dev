package com.fc.advice;

import com.fc.vo.ResultVO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice

public class GlobalExceptionHandler {
    // 对指定的异常进行捕获
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public ResultVO handleDuplicateKeyException(DuplicateKeyException e){
        return new ResultVO(4000,"当前用户名已存在",false,e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultVO handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return new ResultVO(4100,"请输入Json方式的参数",false,e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVO handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return new ResultVO(4200,"缺少了必要的参数",false,e.getMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVO handleRuntimeException(RuntimeException e){
        return new ResultVO(4040,"您的操作有误",false,e.getMessage());
    }
}
