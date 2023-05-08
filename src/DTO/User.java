/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import BUS.UserBUS;

/**
 *
 * @author agond
 */
public class User{
    private static String username;
    private static String password;
    private static boolean nhanVien;

    public static boolean isNhanVien() {
        return nhanVien;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setNhanVien(boolean nhanVien) {
        User.nhanVien = nhanVien;
    }
    
    public static void setUsername(String username) {
        User.username = username;
    }

    public static void setPassword(String password) {
        User.password = password;
    }
    
}
