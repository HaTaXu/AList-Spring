package com.example.alist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    public static final int GENERAL = 0;
    public static final int GUEST = 1;
    public static final int ADMIN = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    @Column(name = "pwd_hash")
    private String pwdHash;

    @Column(name = "pwd_ts")
    private int pwdTS;

    private String salt;

    @Column(name = "user_group")
    private String userGroup;

    @Column(name = "base_path")
    private String basePath = "/";

    private int role;
    private boolean disabled = false;
    private int permission;

    @Column(name = "otp_secret")
    private String otpSecret;

    @Column(name = "sso_id")
    private String ssoID;

    private String authn;

    public User() {}

    public User(String username, String pwdHash, int pwdTS, String salt, int role, int permission) {
        this.username = username;
        this.pwdHash = pwdHash;
        this.pwdTS = pwdTS;
        this.salt = salt;
        this.role = role;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", role=" + role + ", salt=" + salt + "]";
    }

    public boolean isGuest() {
        return role == GUEST;
    }

    public boolean isAdmin() {
        return role == ADMIN;
    }

}
