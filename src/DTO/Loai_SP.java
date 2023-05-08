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
public class Loai_SP{
    private String maLoai, tenLoai;
    DataTranferFor dt = new DataTranferFor("loaisp");

    public Loai_SP() throws IOException {
        maLoai = "ML" + dt.getMaxID();
    }

    public Loai_SP(String tenLoai) throws IOException {
        this.tenLoai = tenLoai;
        maLoai = "ML" + dt.getMaxID();
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }    
    
}
