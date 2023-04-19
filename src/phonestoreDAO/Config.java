/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreDAO;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class Config {
    public void AddConfig(){
        try {
            DatabaseConfig config = new DatabaseConfig();
            config.readConfig();
        } catch (IOException ex) {
            Logger.getLogger(HANG_SX_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
