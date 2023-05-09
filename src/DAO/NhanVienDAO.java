/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class NhanVienDAO implements DataTranfer<NhanVien> {
    private ArrayList<NhanVien> list = new ArrayList<>();    
    private ArrayList<NhanVien> listNV_DK = new ArrayList<>();
    private static int soLuong = 0;
    private NhanVien nv;

    public NhanVienDAO() throws ClassNotFoundException, SQLException, IOException {
        nv = new NhanVien();
        MyConnection myConn = new MyConnection();
    }

    public ArrayList<NhanVien> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    public ArrayList<NhanVien> readData() throws IOException{
        try {
            String sql = "Select * from NHANVIEN";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                nv.setMaNV(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setHoLot(rs.getString(3));
                nv.setDiaChi(rs.getString(4));
                nv.setSDT(rs.getString(5));
                nv.setLuong(rs.getInt(6));
                nv.setUsername(rs.getString(7));
                nv.setPassword(rs.getString(8));
                list.add(nv);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean writeData(NhanVien data) {
        try {
            String sql = "INSERT INTO NHANVIEN (MaNV, Ten, HoLot, DiaChi, SDT, Luong, Username, Pass) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaNV());
            pstmt.setString(2, data.getTen());
            pstmt.setString(3, data.getHoLot());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getSDT());
            pstmt.setInt(6, data.getLuong());
            pstmt.setString(7, data.getUsername());
            pstmt.setString(8, data.getPassword());
            pstmt.executeUpdate();    
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<NhanVien> readDatabyKey(String key) throws IOException { //key = maNV
        try {
            String sql = "Select * from NHANVIEN Where MaNV = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, key);
            ResultSet rs = pre.executeQuery();            
            while (rs.next()) {
                nv.setMaNV(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setHoLot(rs.getString(3));
                nv.setDiaChi(rs.getString(4));
                nv.setSDT(rs.getString(5));
                nv.setLuong(rs.getInt(6));
                nv.setUsername(rs.getString(7));
                nv.setPassword(rs.getString(8));
                listNV_DK.add(nv);
            }
            return listNV_DK;
        } catch (SQLException e) {
        }
        return null;
    }
}
