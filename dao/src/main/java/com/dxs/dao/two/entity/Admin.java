package com.dxs.dao.two.entity;

public class Admin {
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
     * 状态 0：正常 1：禁用 status
     */
    private Integer status;

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
     * 状态 0：正常 1：禁用
     * @author Mr.Dxs
     * @return status 状态 0：正常 1：禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0：正常 1：禁用
     * @author Mr.Dxs
     * @param status 状态 0：正常 1：禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @mbg.generated 2018-11-12 17:14:14
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
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}