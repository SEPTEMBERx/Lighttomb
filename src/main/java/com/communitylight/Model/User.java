package com.communitylight.Model;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer id;

    private String userName;

    private String accountId;

    private String cookie;

    private Long gmtCreatetime;

    private Long gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    public Long getGmtCreatetime() {
        return gmtCreatetime;
    }

    public void setGmtCreatetime(Long gmtCreatetime) {
        this.gmtCreatetime = gmtCreatetime;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}