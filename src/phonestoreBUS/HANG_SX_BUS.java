/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreBUS;
import java.io.IOException;
import java.util.ArrayList;
import phonestoreDAO.*;
import DTO.Hang_SX;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonestoreDAO.HANG_SX_DAO;
/**
 *
 * @author duong
 */
public class HANG_SX_BUS {
    private ArrayList<Hang_SX> listHang;
    private HANG_SX_DAO hangsx_DAO = new HANG_SX_DAO();
       
    public HANG_SX_BUS(){
        readHANG_SX_BUS();
    }
    
    public void readHANG_SX_BUS(){
        try {
            this.listHang = hangsx_DAO.readHANG_SX();
        } catch (SQLException ex) {
            Logger.getLogger(HANG_SX_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
