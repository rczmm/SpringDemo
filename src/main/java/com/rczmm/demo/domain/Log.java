package com.rczmm.demo.domain;

import java.util.Date;

/**
 * 日志类
 *
 * @author rczmm
 * @date 2024/05/21 10:45
 */
public class Log {

    /**
     * 日志id
     */
    private String logId;

    /**
     * ip
     */
    private String ip;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志描述
     */
    private String description;

    /**
     * 日志模型
     */
    private String model;

    /**
     * 日志操作时间
     */
    private Date operationTime;

    /**
     * 日志结果
     */
    private String result;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
