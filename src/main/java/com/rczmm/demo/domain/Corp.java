package com.rczmm.demo.domain;

/**
 * 部门，存储部门信息对象 corp
 *
 * @author rczmm
 * @date 2024-05-13
 */
public class Corp extends BaseDO {

    /**
     * 部门id
     */
    private Long id;

    /**
     * 父部门id
     */
    private Long pid;

    /**
     * 部门名
     */
    private String name;

    /**
     * 部门类型
     */
    private String type;

    /**
     * 部门状态
     */
    private String status;

    /**
     * 部门描述
     */
    private String description;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getPid() {
        return pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
