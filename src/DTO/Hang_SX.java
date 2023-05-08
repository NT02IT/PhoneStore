/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.IOException;

/**
 *
 * @author duong
 */
public class Hang_SX{
    private String maHang, tenHang;
    DataTranferFor dt = new DataTranferFor("hangsx");

    public Hang_SX(String tenHang) throws IOException {
        maHang = "MH" + dt.getMaxID();
        this.tenHang = tenHang;
    }
    public Hang_SX() throws IOException{
        maHang = "MH" + dt.getMaxID();
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
}
