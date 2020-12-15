package com.returncode.common.result;

import java.util.Date;

/**
 * 基础的返回结果
 *
 * @Author: wanglei
 * @Date: 2020/7/8
 */
public class Result {

    private Date timestamp;
    private int status;
    private String path;

    public Result(Date timestamp, int status, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
