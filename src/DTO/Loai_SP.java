/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author duong
 */
public class Loai_SP {
    private static int soLuongLoai = 0;
    private int maLoai;
    private String tenLoai;

    public Loai_SP() {
        soLuongLoai++;
        maLoai += 100 + soLuongLoai;
    }

    public Loai_SP(String tenLoai) {
        this.tenLoai = tenLoai;
        soLuongLoai++;
        maLoai += 100 + soLuongLoai;
    }

    public int getSoLuongLoai() {
        return soLuongLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }    
    
}
