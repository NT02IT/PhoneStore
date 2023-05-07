/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Loai_SP;
import java.io.IOException;
import java.sql.Connection;
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
public class LoaiSanPhamDAO {
    
    public LoaiSanPhamDAO(){
        
    }
    
    //lấy dữ liệu các loại sp từ database và trả về 1 arraylist chứa các loại sp
    public ArrayList readLOAI_SP() throws IOException{
        ArrayList<Loai_SP> loai_sp = new ArrayList<>();
        try {
            String sql = "Select * from LOAI_SP";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Loai_SP loaisp = new Loai_SP();
                loaisp.setMaLoai(rs.getString("MaLoai"));
                loaisp.setTenLoai(rs.getString("TenLoai"));
                loai_sp.add(loaisp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loai_sp;
    }
}
