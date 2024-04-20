package com.example.alist.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateRandomString {
    public static String CharSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String randomString(int n) {
        StringBuilder rs = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            rs.append(CharSet.charAt(random.nextInt(CharSet.length())));
        }
        return rs.toString();
    }
}
