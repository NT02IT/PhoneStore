/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import java.io.IOException;
import java.util.ArrayList;
import DTO.Hang_SX;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.HangSxDAO;
/**
 *
 * @author duong
 */
public class HANG_SX_BUS {
    private ArrayList<Hang_SX> listHang;
    private HangSxDAO hangsx_DAO = new HangSxDAO();
       
    public HANG_SX_BUS() throws IOException{
        readHANG_SX_BUS();
    }
    
    public void readHANG_SX_BUS() throws IOException{
        try {
            this.listHang = hangsx_DAO.readHANG_SX();
        } catch (SQLException ex) {
            Logger.getLogger(HANG_SX_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
