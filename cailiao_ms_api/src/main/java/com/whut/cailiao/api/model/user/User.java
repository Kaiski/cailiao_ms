package com.whut.cailiao.api.model.user;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
public class User implements Serializable {

    private String accountId;
    private String password;
    private String description;

    private Integer factoryId;
    private String email;

    private int status;

    private Set<Integer> privilegeIds;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Integer> getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(Set<Integer> privilegeIds) {
        this.privilegeIds = privilegeIds;
    }
}
