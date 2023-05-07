/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
/**
 *
 * @author duong
 */
public class SanPham_DAO {
    public SanPham_DAO(){
        
    }
    
    //Hàm đọc sản phẩm từ db
    //lấy dữ liệu các sản phẩm từ database và trả về 1 arraylist chứa các sản phẩm
    public ArrayList readSANPHAM() {
        ArrayList<SanPham> sanpham = new ArrayList<>();
        try {
            String sql = "Select * from SAN_PHAM";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setMaLoai(rs.getString("MaLoai"));
                sanpham.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanpham;
    }
    
    //Hàm lấy sản phẩm từ db
    //Đầu vào là mã sản phẩm, trả về là sản phẩm tìm đc trong db hoặc null (ko tìm thấy)
    public SanPham getSANPHAM(String ma){
        try {
            String sql = "Select * from SAN_PHAM where MaSP = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, ma);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaLoai(rs.getString(6));
                
                return sp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Hàm lấy các sản phẩm từ db
    //Đầu vào là mã loại, trả về là 1 arraylist chứa các sản phẩm thuộc loại tương ứng hoặc null (ko tìm thấy)
    public ArrayList<SanPham> getSanPhamTheoLoai(int maLoai) {
        try {
            String sql = "Select * from SAN_PHAM Where MaLoai = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setInt(1, maLoai);
            ResultSet rs = pre.executeQuery();
            ArrayList<SanPham> dssp = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaLoai(rs.getString(6));

                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException e) {
        }

        return null;
    }
    
    //Hàm thêm sản phẩm vào db
    //Đầu vào là đối tượng sản phẩm, trả về true (thêm thành công) hoặc false (thêm thất bại)
    public boolean addSANPHAM(SanPham sp){
        try {
            String sql = "Insert into SAN_PHAM (MaSP, TenSP, SoLuong, DonGia, DonViTinh, MaLoai) "
                    + "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, sp.getMaSP());
            pre.setString(2, sp.getTenSP());;
            pre.setInt(3, sp.getSoLuong());
            pre.setInt(4, sp.getDonGia());
            pre.setString(5, sp.getDonViTinh());
            pre.setString(6, sp.getMaLoai());
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
