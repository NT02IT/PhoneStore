/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPham;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author agond
 */

public class SanPhamDAO {
    private ArrayList<SanPham> list = new ArrayList<>();
    private static int soLuong = 0;
    private SanPham sp;

    public SanPhamDAO() throws ClassNotFoundException, SQLException, IOException {
        sp = new SanPham();
        MyConnection myConn = new MyConnection();
    }

    public ArrayList<SanPham> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
        
    public void readData() throws IOException{
        try {
            String sql = "Select * from SANPHAM";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){   
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaLoai(rs.getString(6));
                list.add(sp);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeData(SanPham sp) {
        try {
            String sql = "INSERT INTO SANPHAM (MaSP, TenSP, SoLuong, DonGia, DonViTinh, MaLoai) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, sp.getMaSP());
            pstmt.setString(2, sp.getTenSP());
            pstmt.setInt(3, sp.getSoLuong());
            pstmt.setInt(4, sp.getDonGia());
            pstmt.setString(5, sp.getDonViTinh());
            pstmt.setString(6, sp.getMaLoai());
            pstmt.executeUpdate();        
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
