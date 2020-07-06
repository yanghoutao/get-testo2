package com.hj.pas.exception;

/**
 * 基础异常类.
 *
 * @author zq
 */
public abstract class BaseException extends Exception {

    private static final long serialVersionUID = 1L;

    // e.g. ORDER_FROZEN
    private int code;

    private String message;

    private Object[] parameters;

    /**
     * 不应该直接实例化,应该定义子类.
     *
     * @param code       异常 code,通常与模块 CODE 对应
     * @param message    异常消息代码,系统描述中定义
     * @param parameters 如果没有参数,可以传 null
     */
    public BaseException(int code, String message, Object[] parameters) {
        super(message);
        this.code = code;
        this.message = message;
        this.parameters = parameters;
    }

    public int getCode() {
        return code;
    }

    public String getDescriptionKey() {
        return message;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescriptionKey(String message) {
        this.message = message;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
