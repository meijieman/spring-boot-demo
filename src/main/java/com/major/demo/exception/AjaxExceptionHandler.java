package com.major.demo.exception;

import com.major.demo.entiy.Response;

import javax.servlet.http.HttpServletRequest;

// ajax 捕获异常
//@RestControllerAdvice
public class AjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    public Response defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        e.printStackTrace();
        return Response.exception(e.getMessage());
    }
}