package com.major.demo.entiy;

// 必须设置 getter/setter
public class Response {

    private String msg;
    private int code;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Response success(Object obj){
        Response resp = new Response();
        resp.code = 200;
        resp.msg = "success";
        resp.data = obj;
        return resp;
    }

    public static Response error(int code, String msg){
        Response resp = new Response();
        resp.code = code;
        resp.data = msg;
        return resp;
    }

    public static Response exception(String message) {
        Response resp = new Response();
        resp.code = 555;
        resp.msg = message;
        return resp;
    }
}
