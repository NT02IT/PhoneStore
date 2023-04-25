/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Hang_SX;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class HANG_SX_DAO {
    
    public HANG_SX_DAO(){
        
    }
    
    //lấy dữ liệu các hãng sx từ database và trả về 1 arraylist chứa các hãng sx
    public ArrayList readHANG_SX() throws SQLException{
        ArrayList<Hang_SX> hsx = new ArrayList<>();
        String sql = "Select * from HANG_SX";
        Statement stmt = MyConnection.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Hang_SX data = new Hang_SX();
            data.setMaHang(rs.getString("MaHang"));
            data.setTenHang(rs.getString("TenHang"));
            hsx.add(data);
        }
        return hsx;
    }   
}
