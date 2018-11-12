package com.dxs.dao.one.entity;

import java.util.Date;

public class User {
    /**
     * 主键 pk_id
     */
    private Integer pkId;

    /**
     * 账户 account
     */
    private String account;

    /**
     * 密码 password
     */
    private String password;

    /**
     * 昵称 nickname
     */
    private String nickname;

    /**
     * 盐值 salt
     */
    private String salt;

    /**
     * 是否删除 0：正常 1：删除 delete_flag
     */
    private Integer deleteFlag;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * 主键
     * @author Mr.Dxs
     * @return pk_id 主键
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 主键
     * @author Mr.Dxs
     * @param pkId 主键
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 账户
     * @author Mr.Dxs
     * @return account 账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账户
     * @author Mr.Dxs
     * @param account 账户
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 密码
     * @author Mr.Dxs
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @author Mr.Dxs
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 昵称
     * @author Mr.Dxs
     * @return nickname 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     * @author Mr.Dxs
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 盐值
     * @author Mr.Dxs
     * @return salt 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐值
     * @author Mr.Dxs
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 是否删除 0：正常 1：删除
     * @author Mr.Dxs
     * @return delete_flag 是否删除 0：正常 1：删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 是否删除 0：正常 1：删除
     * @author Mr.Dxs
     * @param deleteFlag 是否删除 0：正常 1：删除
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 创建时间
     * @author Mr.Dxs
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @author Mr.Dxs
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbg.generated 2018-11-12 17:15:34
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", salt=").append(salt);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}