/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreDAO;

import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class MyConnection {
    
    public MyConnection(){
        
    }

    public Connection get(DatabaseConfig config) throws IOException {
        Connection conn = null;
        if(conn == null){
            try {
                System.out.println(config.getDatabase());
                String connectionString = String.format(
                    "jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true",
                    config.getServer(), config.getPort(), config.getDatabase(), config.getUsername(),
                    config.getPassword());
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = (Connection) DriverManager.getConnection(connectionString);
                System.out.println("Ket noi database thanh ");
            } catch (java.lang.ClassNotFoundException e){
                try {
                    throw new Exception("Driver not found");
                } catch (Exception ex) {
                    Logger.getLogger(HANG_SX_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HANG_SX_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
    
}
