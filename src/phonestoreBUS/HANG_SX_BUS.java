/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreBUS;
import java.io.IOException;
import java.util.ArrayList;
import phonestoreDAO.ConfigReader;
import phonestoreDAO.DatabaseConfig;
import phonestoreDAO.HANG_SX_DAO;
import ObjectData.Hang_SX;
import java.sql.SQLException;
/**
 *
 * @author duong
 */
public class HANG_SX_BUS {
    public HANG_SX_BUS(){
        
    }
    //khai báo các arraylist trung gian, lưu trữ dữ liệu để thực hiện truy xuất mà ko cần load database
    static ArrayList<Hang_SX> hang_sx = new ArrayList<>();
    
    //khai báo DAO
    HANG_SX_DAO dt = new HANG_SX_DAO();
    
    //lấy data hãng sản xuất đưa lên arraylist trung gian
    public void getHang_sx() throws SQLException{
        
    }
    
    //lấy database config
    public void getDBConfig(){
        
    }
}
