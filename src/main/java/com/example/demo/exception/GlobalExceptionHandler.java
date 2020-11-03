package com.example.demo.exception;

import com.example.demo.base.util.ResultInfo;
import com.example.demo.base.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理器
 * @Autor ansonglin
 * @Date 2019/5/7 11:21
 * @Version 1.0
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 处理自定义异常，可在此处集中输出异常日志
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseRuntimeException.class)
    public ResultInfo exceptionHandler(BaseRuntimeException e) {
        return ResultUtil.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理未捕获异常，打印出堆栈详情
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultInfo exceptionHandler(Exception e, HttpServletResponse response) {
        response.setStatus(ExceptionConstant.SERVER_ERROR_CODE);
        log.error("系统出现未捕获异常，异常信息为：", e.getMessage(), e);
        return ResultUtil.error("系统出现异常无法完成操作,请联系管理员");
    }

    /**
     * 参数校验异常类处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultInfo exceptionHandler(IllegalArgumentException e) {
        return ResultUtil.error(ExceptionConstant.CHECKFAIL_ERROR_CODE, e.getMessage());
    }

}
   