package com.nowcode.blive.domain.exception;

/**
 * @Title: ConditionException
 * @Package: com.nowcode.blive.domain.exception
 * @description:
 * @author: Stackingrule
 * @created: 2022/02/25 19:46
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
public class ConditionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    public ConditionException(String code, String name) {
        super(name);
        this.code = code;
    }

    public ConditionException(String name) {
        super(name);
        code = "500";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
