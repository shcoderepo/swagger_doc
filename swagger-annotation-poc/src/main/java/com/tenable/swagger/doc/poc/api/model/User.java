package com.tenable.swagger.doc.poc.api.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


public class User {
    String uuid;
    Integer id;
    String username;
    String name;
    String email;
    String type;
    Boolean aggregate;
    String containerUuid;
    Integer permissions;
    Integer loginFailCount;
    Integer loginFailTotal;
    Boolean enabled;
    Integer lockout;

    @Schema(description = "The login name for the user. A valid username must be in the format, `name@domain`," +
            " where `domain` corresponds to a domain approved for your Tenable.io instance.\\n\\n**Note:** During initial setup," +
            " Tenable configures approved domains for your Tenable.io instance. " +
            "To add domains to your instance, contact Tenable Support.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Schema(description = "The email address of the user. A valid email address must be in the format, `name@domain`," +
            " where `domain` corresponds to a domain approved for your Tenable.io instance.\\n\\nThis email address" +
            " overrides the email address set in `username`. If your request omits this parameter, Tenable.io" +
            " uses the `username` value as the user's email address.\\n\\n**Note:** During initial setup," +
            " Tenable configures approved domains for your Tenable.io instance. To add domains to your instance," +
            " contact Tenable Support.")
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAggregate() {
        return aggregate;
    }

    public void setAggregate(Boolean aggregate) {
        this.aggregate = aggregate;
    }


    public String getContainerUuid() {
        return containerUuid;
    }

    public void setContainerUuid(String containerUuid) {
        this.containerUuid = containerUuid;
    }


    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }


    public Integer getLoginFailCount() {
        return loginFailCount;
    }

    public void setLoginFailCount(Integer loginFailCount) {
        this.loginFailCount = loginFailCount;
    }


    public Integer getLoginFailTotal() {
        return loginFailTotal;
    }

    public void setLoginFailTotal(Integer loginFailTotal) {
        this.loginFailTotal = loginFailTotal;
    }


    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public Integer getLockout() {
        return lockout;
    }

    public void setLockout(Integer lockout) {
        this.lockout = lockout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid) &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(type, user.type) &&
                Objects.equals(aggregate, user.aggregate) &&
                Objects.equals(containerUuid, user.containerUuid) &&
                Objects.equals(permissions, user.permissions) &&
                Objects.equals(loginFailCount, user.loginFailCount) &&
                Objects.equals(loginFailTotal, user.loginFailTotal) &&
                Objects.equals(enabled, user.enabled) &&
                Objects.equals(lockout, user.lockout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, id, username, name, email, type, aggregate, containerUuid, permissions, loginFailCount, loginFailTotal, enabled, lockout);
    }
}
