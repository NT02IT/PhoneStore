/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class NhaCungCap {
    private static int soLuongNCC = 0;
    private String maNCC, tenNCC, diaChi, SDT;

    public NhaCungCap() {
        soLuongNCC++;
        maNCC = "NCC" + soLuongNCC;
    }

    public NhaCungCap(String tenNCC, String diaChi, String SDT) {
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.SDT = SDT;
        soLuongNCC++;
        maNCC = "NCC" + soLuongNCC;
    }  

    public static int getSoLuongNCC() {
        return soLuongNCC;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}
