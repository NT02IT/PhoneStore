/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Hang_SX;
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
 * @author duong
 */
public class HangSxDAO {
    private ArrayList<Hang_SX> list = new ArrayList<>();
    private ArrayList<Hang_SX> listHSX_DK = new ArrayList<>(); 
    private static int soLuong = 0;
    private Hang_SX hsx;
    
    public HangSxDAO() throws IOException, ClassNotFoundException, SQLException{
        hsx = new Hang_SX();
        MyConnection myConn = new MyConnection();
    }
    
    public ArrayList<Hang_SX> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    public ArrayList<Hang_SX> readData() throws IOException{
        try {
            String sql = "Select * from HANG_SX";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){   
                hsx.setMaHang(rs.getString("MaHang"));
                hsx.setTenHang(rs.getString("TenHang"));
                list.add(hsx);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    public boolean writeData(Hang_SX hsx) {
        try {
            String sql = "INSERT INTO HANG_SX (MaHang, TenHang) VALUES (?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, hsx.getMaHang());
            pstmt.setString(2, hsx.getTenHang());
            pstmt.executeUpdate();    
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Hang_SX> readDatabyKey(String maHang) throws IOException {
        try {
            String sql = "Select * from HANG_SX Where MaHang = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, maHang);
            ResultSet rs = pre.executeQuery();            
            while (rs.next()) {
                hsx.setMaHang(rs.getString("MaHang"));
                hsx.setTenHang(rs.getString("TenHang"));
                listHSX_DK.add(hsx);
            }
            return listHSX_DK;
        } catch (SQLException e) {
        }
        return null;
    }
}
