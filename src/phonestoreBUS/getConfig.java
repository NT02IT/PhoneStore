/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreBUS;
import phonestoreDAO.Config;
import phonestoreDAO.HANG_SX_DAO;
/**
 *
 * @author duong
 */
public class getConfig {
    //gọi hàm đọc config từ lớp DAO và lưu vào đối tượng DatabaseConfig
    public void readConfig(){
        Config cf = new Config();
        cf.AddConfig();
    }
}
