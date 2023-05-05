/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CT_SanPham;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author duong
 */
public class CT_SanPham_DAO {
    
    public CT_SanPham_DAO(){
        
    }
    
    //lấy dữ liệu các hãng sx từ database và trả về 1 arraylist chứa các hãng sx
    public ArrayList<CT_SanPham> readCT_SANPHAM() {
        ArrayList<CT_SanPham> ctsanpham = new ArrayList<>();
        try {
            String sql = "Select * from CT_SP";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                CT_SanPham ct_sanpham = new CT_SanPham();
                ct_sanpham.setMaSP(rs.getString("MaSP"));
                ct_sanpham.setMaLoai(rs.getString("MaLoai"));
                ct_sanpham.setMoTaSP(rs.getString("MoTaSP"));
                ct_sanpham.setMaHang(rs.getString("MaHang"));
                ctsanpham.add(ct_sanpham);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CT_SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctsanpham;
    }
    
}
