package com.example.alist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    public static final int GENERAL = 0;
    public static final int GUEST = 0;
    public static final int ADMIN = 0;

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

    @Transient
    private String password;

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

    protected User() {}

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", role=" + role + ", password=" + password + "]";
    }

    public boolean isGuest() {
        return role == GUEST;
    }

    public boolean isAdmin() {
        return role == ADMIN;
    }

}
