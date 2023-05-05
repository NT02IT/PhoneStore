/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author duong
 */
public class SanPham_DAO {
    public SanPham_DAO(){
        
    }
    
    //lấy dữ liệu các sản phẩm từ database và trả về 1 arraylist chứa các sản phẩm
    public ArrayList readSANPHAM() {
        ArrayList<SanPham> sanpham = new ArrayList<>();
        try {
            String sql = "Select * from SAN_PHAM";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setMaLoai(rs.getInt("MaLoai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanpham;
    }
}
