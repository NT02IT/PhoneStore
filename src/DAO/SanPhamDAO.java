/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPham;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.MyConnection;
import DTO.ID;

import Connection.MyConnection;
/**
 *
 * @author agond
 */

public class SanPhamDAO implements Action<SanPham> {
    private ArrayList<SanPham> list = new ArrayList<>();
    private static int soLuong = 0;
    private SanPham sp;
    ID maxMaSP = new ID("sanpham");

    public SanPhamDAO() throws ClassNotFoundException, SQLException, IOException {
        MyConnection myConn = new MyConnection();
        read();
    }

    
    public ArrayList<SanPham> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    public ArrayList<SanPham> read() throws IOException{
        try {
            String sql = "Select * from SANPHAM";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){   
                sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSLTrongKho(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaLoai(rs.getString(6));
                list.add(sp);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean write(SanPham data) throws IOException{
        try {
            data.setMaSP("SP" + maxMaSP.getMax());
            String sql = "INSERT INTO SANPHAM (MaSP, TenSP, SoLuong, DonGia, DonViTinh, MaLoai) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaSP());
            pstmt.setString(2, data.getTenSP());
            pstmt.setInt(3, data.getSLTrongKho());
            pstmt.setInt(4, data.getDonGia());
            pstmt.setString(5, data.getDonViTinh());
            pstmt.setString(6, data.getMaLoai());
            pstmt.executeUpdate(); 
            soLuong++;
            list.add(data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(SanPham data) {
        try {
            String sql = "DELETE FROM SANPHAM WHERE MaSP = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaSP());
            pstmt.executeUpdate();     
            soLuong--;
            list.remove(searchByID(data.getMaSP()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(SanPham data) {
        try {
            String sql = "UPDATE SANPHAM SET TenSP = ?, SoLuong = ?, DonGia = ?, DonViTinh = ?, MaLoai = ? WHERE MaSP = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenSP());
            pstmt.setInt(2, data.getSLTrongKho());
            pstmt.setInt(3, data.getDonGia());
            pstmt.setString(4, data.getDonViTinh());
            pstmt.setString(5, data.getMaLoai());
            pstmt.setString(6, data.getMaSP());
            pstmt.executeUpdate();
            list.set(searchByID(data.getMaSP()), data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

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
