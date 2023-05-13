/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CT_SanPham;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.MyConnection;

import Connection.MyConnection;
/**
 *
 * @author duong
 */
public class CT_SanPhamDAO implements Action<CT_SanPham> {
    private ArrayList<CT_SanPham> list = new ArrayList<>();
    private static int soLuong = 0;
    private CT_SanPham ctsp;
    
    public CT_SanPhamDAO() throws ClassNotFoundException, SQLException, IOException{
        MyConnection myConn = new MyConnection();
        read();
    }
    
    public ArrayList<CT_SanPham> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    @Override
    public ArrayList<CT_SanPham> read() throws IOException{
        try {
            String sql = "Select * from CT_SP";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){  
                ctsp = new CT_SanPham();
                ctsp.setMaSP(rs.getString(1));
                ctsp.setMaLoai(rs.getString(2));
                ctsp.setMaHang(rs.getString(3));
                ctsp.setMoTaSP(rs.getString(4));                
                list.add(ctsp);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CT_SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean write(CT_SanPham data) {
        try {
            String sql = "INSERT INTO CT_SP (MaSP, MaLoai, MaHang, MoTaSP) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaSP());
            pstmt.setString(2, data.getMaLoai());
            pstmt.setString(3, data.getMaHang());   
            pstmt.setString(4, data.getMoTaSP());
            pstmt.executeUpdate();    
            soLuong++;
            list.add(data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CT_SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean delete(CT_SanPham data) {
        try {
            String sql = "DELETE FROM CT_SP WHERE MaSP = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaSP());
            pstmt.executeUpdate();     
            soLuong--;
            list.remove(searchByID(data.getMaSP()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CT_SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(CT_SanPham data) {
        try {
            String sql = "UPDATE SANPHAM SET MaLoai = ?, MaHang = ?, MoTaSP = ? WHERE MaSP = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaLoai());
            pstmt.setString(2, data.getMaHang());
            pstmt.setString(3, data.getMoTaSP());
            pstmt.setString(4, data.getMaSP());
            pstmt.executeUpdate();
            list.set(searchByID(data.getMaSP()), data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CT_SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int searchByID(String ID) { // ID = MaSP
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSP().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
