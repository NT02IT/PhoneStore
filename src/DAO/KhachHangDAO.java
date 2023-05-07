/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHang;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class KhachHangDAO {
    private ArrayList<KhachHang> list = new ArrayList<>();
    private static int soLuong = 0;
    private KhachHang kh;

    public KhachHangDAO() throws ClassNotFoundException, SQLException, IOException {
        kh = new KhachHang();
        MyConnection myConn = new MyConnection();
    }

    public ArrayList<KhachHang> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
        
    public void readData() throws IOException{
        try {
            String sql = "Select * from KHACHHANG";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){   
                kh.setMaKH(rs.getString(1));
                kh.setTen(rs.getString(2));
                kh.setHoLot(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSDT(rs.getString(5));
                kh.setUsername(rs.getString(6));
                kh.setPassword(rs.getString(7));
                list.add(kh);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeData(KhachHang kh) {
        try {
            String sql = "INSERT INTO KHACHHANG (MaKH, Ten, HoLot, DiaChi, SDT, Username, Pass) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, kh.getMaKH());
            pstmt.setString(2, kh.getTen());
            pstmt.setString(3, kh.getHoLot());
            pstmt.setString(4, kh.getDiaChi());
            pstmt.setString(5, kh.getSDT());
            pstmt.setString(6, kh.getUsername());
            pstmt.setString(7, kh.getPassword());
            pstmt.executeUpdate();        
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
