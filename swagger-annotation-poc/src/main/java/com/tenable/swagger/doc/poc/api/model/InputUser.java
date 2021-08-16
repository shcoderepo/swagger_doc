package com.tenable.swagger.doc.poc.api.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

public class InputUser {
    String username;
    String name;
    String password;
    String email;
    Integer permissions;

    @Schema(description = "The login name for the user. A valid username must be in the format, `name@domain`," +
            " where `domain` corresponds to a domain approved for your Tenable.io instance.\\n\\n**Note:** During initial setup," +
            " Tenable configures approved domains for your Tenable.io instance. " +
            "To add domains to your instance, contact Tenable Support.", required = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Schema(description = "The name of the user (for example, first and last name).")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Schema(description = "The initial password for the user. Passwords must be at least 12 characters long and contain" +
            " at least one uppercase letter, one lowercase letter, one number, and one special character symbol.",
    format = "password", required = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Schema(description = "The user permissions as described in [Permissions](doc:permissions).", required = true)
    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }
}
