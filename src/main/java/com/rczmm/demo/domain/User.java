package com.rczmm.demo.domain;


/**
 * 用户，存储用户信息对象 user
 *
 * @author rczmm
 * @date 2024-05-13
 */
public class User extends BaseDO{

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 部门ID
     */
    private Long corpId;

    private String createTime;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    public Long getCorpId() {
        return corpId;
    }

}
