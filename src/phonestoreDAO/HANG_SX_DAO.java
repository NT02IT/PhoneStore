/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreDAO;

import ObjectData.Hang_SX;
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
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public HANG_SX_DAO(){
        
    }
    
    public ArrayList readHANG_SX() throws SQLException{
        ArrayList<Hang_SX> hsx = new ArrayList<>();
        try {
            String sql = "Select * from HANG_SX";
            DatabaseConfig cf = new DatabaseConfig();
            cf.readConfig();
            MyConnection connect = new MyConnection();
            conn = connect.get(cf);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Hang_SX data = new Hang_SX();
                data.setMaHang(rs.getString("MaHang"));
                data.setTenHang(rs.getString("TenHang"));
                hsx.add(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(HANG_SX_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hsx;
    }
}
