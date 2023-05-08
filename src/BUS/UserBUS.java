/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DAO.MyConnection;
import DAO.NhanVienDAO;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.User;
import java.beans.Statement;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class UserBUS extends User{
    public ArrayList readUser() throws IOException {
        ArrayList<User> user = new ArrayList<>();
        try {
            String sql = "Select * from KHACHHANG";
            java.sql.Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setUsername(rs.getString("Username"));
                kh.setPassword(rs.getString("Pass"));
                kh.setNhanVien(false);
                user.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "Select * from NHANVIEN";
            java.sql.Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setUsername(rs.getString("Username"));
                nv.setPassword(rs.getString("Pass"));
                nv.setNhanVien(true);
                user.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
