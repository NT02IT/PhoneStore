/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author duong
 */
public class Hang_SX {
    private static int soHangSX = 0;
    private int maHang;
    private String tenHang;

    public Hang_SX(String tenHang) {
        soHangSX++;
        maHang += 100 + soHangSX;
        this.tenHang = tenHang;
    }
    public Hang_SX(){
        soHangSX++;
        maHang += 100 + soHangSX;
    }

    public static int getSoHangSX() {
        return soHangSX;
    }

    public int getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
}
