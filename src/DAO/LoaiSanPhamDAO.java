/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Loai_SP;
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
 * @author duong
 */
public class LoaiSanPhamDAO implements DataTranfer<Loai_SP> {
    private ArrayList<Loai_SP> list = new ArrayList<>();    
    private ArrayList<Loai_SP> listLoaiSP_DK = new ArrayList<>(); 
    private static int soLuong = 0;
    private Loai_SP loaiSP;
    
    public LoaiSanPhamDAO() throws IOException, ClassNotFoundException, SQLException{
        loaiSP = new Loai_SP();
        MyConnection myConn = new MyConnection();        
    }
    
    public ArrayList<Loai_SP> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    public ArrayList<Loai_SP> readData() throws IOException{
        try {
            String sql = "Select * from LOAI_SP";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){   
                loaiSP.setMaLoai(rs.getString(1));
                loaiSP.setTenLoai(rs.getString(2));
                list.add(loaiSP);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean writeData(Loai_SP loaiSP) {
        try {
            String sql = "INSERT INTO LOAI_SP (MaLoai, TenLoai) VALUES (?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, loaiSP.getMaLoai());
            pstmt.setString(2, loaiSP.getTenLoai());
            pstmt.executeUpdate();    
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Loai_SP> readDatabyKey(String maLoai) throws IOException {
        try {
            String sql = "Select * from LOAI_SP Where MaLoai = ?";
            PreparedStatement pre = MyConnection.conn.prepareStatement(sql);
            pre.setString(1, maLoai);
            ResultSet rs = pre.executeQuery();            
            while (rs.next()) {
                loaiSP.setMaLoai(rs.getString(1));
                loaiSP.setTenLoai(rs.getString(2));
                listLoaiSP_DK.add(loaiSP);
            }
            return listLoaiSP_DK;
        } catch (SQLException e) {
        }
        return null;
    }

}
