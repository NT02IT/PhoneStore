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

public class SanPhamDAO implements DataTranfer<SanPham> {
    private ArrayList<SanPham> list = new ArrayList<>();
    private ArrayList<SanPham> listSP_DK = new ArrayList<>(); // Không có nhu cầu lưu trữ list theo loại hay theo đkiện khác nên đặt tên listSP_DK : list sản phẩm với điều kiện -> để có thể dùng chung nếu sau này có thêm phươngthwucs get theo điều kiện khác nữa
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
    
    //Hàm đọc sản phẩm từ db và trả về arraylist
    public ArrayList<SanPham> readData() throws IOException{
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
        return list;
    }
    
    //Hàm thêm sản phẩm vào db
    //Đầu vào là đối tượng sản phẩm, trả về true (thêm thành công) hoặc false (thêm thất bại)
    public boolean writeData(SanPham data) {
        try {
            String sql = "INSERT INTO SANPHAM (MaSP, TenSP, SoLuong, DonGia, DonViTinh, MaLoai) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaSP());
            pstmt.setString(2, data.getTenSP());
            pstmt.setInt(3, data.getSoLuong());
            pstmt.setInt(4, data.getDonGia());
            pstmt.setString(5, data.getDonViTinh());
            pstmt.setString(6, data.getMaLoai());
            pstmt.executeUpdate();    
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Hàm lấy các sản phẩm từ db
    //Đầu vào là mã loại, trả về là 1 arraylist chứa các sản phẩm thuộc loại tương ứng hoặc null (ko tìm thấy)
    public ArrayList<SanPham> readDatabyKey(String key) throws IOException { //KEY = MaLoai
        try {
            String sql = "Select * from SAN_PHAM Where MaLoai = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, key);
            ResultSet rs = pre.executeQuery();            
            while (rs.next()) {
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaLoai(rs.getString(6));
                listSP_DK.add(sp);
            }
            return listSP_DK;
        } catch (SQLException e) {
        }
        return null;
    }
    
    //Hàm xóa sản phẩm từ db
    //Đầu vào là đối tượng, trả về true (xóa thành công) hoặc false (ko thành công)
    public boolean deleteData(String ma){
        try {
            String sql = "Delete * from SAN_PHAM where MaSP = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, ma);
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Hàm sửa sản phẩm từ db
    //Đầu vào là đố tượng cần sửa, đầu ra là true (sửa thành công) hoặc false (sửa thất bại)
    public boolean updateData(SanPham sp){
        try {
            String sql = "Update SAN_PHAM set (MaSP, TenSP, SoLuong, DonGia, DonViTinh, MaLoai)"
                    + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, sp.getMaSP());
            pre.setString(2, sp.getTenSP());
            pre.setInt(3, sp.getSoLuong());
            pre.setInt(4, sp.getDonGia());
            pre.setString(5, sp.getDonViTinh());
            pre.setString(6, sp.getMaLoai());
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
