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

import Connection.MyConnection;
/**
 *
 * @author agond
 */

public class SanPhamDAO implements Action<SanPham> {
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
            String sql = "SELECT SANPHAM.MaSP, SANPHAM.TenSP, SANPHAM.SoLuong, SANPHAM.DonGia, SANPHAM.DonViTinh, HANG_SX.TenHang, CT_SP.MotaSP, LOAI_SP.TenLoai FROM SANPHAM, CT_SP, LOAI_SP, HANG_SX WHERE SANPHAM.MaSP = CT_SP.MaSP AND SANPHAM.MaLoai = LOAI_SP.MaLoai AND CT_SP.MaHang = HANG_SX.MaHang";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){   
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSLTrongKho(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHangSX(rs.getString(6));
                sp.setMoTaSP(rs.getString(7));
                sp.setLoaiSP(rs.getString(8));
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
    public boolean writeData(SanPham data) throws IOException{
        try {
            String sql = "INSERT INTO SANPHAM (MaSP, TenSP, SoLuong, DonGia, DonViTinh, MaLoai) VALUES (?, ?, ?, ?, ?, ?)"
                    + " GO INSERT INTO CT_SP (MaSP, MaLoai, MaHang, MoTaSP) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaSP());
            pstmt.setString(2, data.getTenSP());
            pstmt.setInt(3, data.getSLTrongKho());
            pstmt.setInt(4, data.getDonGia());
            pstmt.setString(5, data.getDonViTinh());
            pstmt.setString(6, data.getMaLoai());
            pstmt.setString(7, data.getMaSP());
            pstmt.setString(8, data.getMaLoai());
            pstmt.setString(9, data.getMaHang());
            pstmt.setString(10, data.getMoTaSP());
            pstmt.executeUpdate(); 
            list.add(sp);
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
                sp.setSLTrongKho(rs.getInt(3));
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
    public boolean deleteData(SanPham sp) throws IOException{
        try {
            String sql = "Delete * from SAN_PHAM where MaSP = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, sp.getMaSP());
            pre.executeUpdate();
            list.remove(sp);
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
            String sql = "Update SAN_PHAM set "
                    + "TenSP = ?, "
                    + "SoLuong = ?, "
                    + "DonGia = ?, "
                    + "DonViTinh = ?, "
                    + "MaLoai = ? "
                    + "values (?, ?, ?, ?, ?) "
                    + "where MaSP = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, sp.getTenSP());
            pre.setInt(2, sp.getSLTrongKho());
            pre.setInt(3, sp.getDonGia());
            pre.setString(4, sp.getDonViTinh());
            pre.setString(5, sp.getMaLoai());
            pre.setString(6, sp.getMaSP());
            pre.executeUpdate();
            list.
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
