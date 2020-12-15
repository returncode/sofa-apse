package com.returncode.apseboot.common.result;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 成功的返回结果（供对位接口使用）
 *
 * @Author: wanglei
 * @Date: 2020/7/8
 */
public class SuccResult<T> extends Result {

    private T data;

    public SuccResult(HttpServletRequest request, T data) {
        super(new Date(), 200, request.getRequestURI());
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
