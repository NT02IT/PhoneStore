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
    private ArrayList<Hang_SX> hangsx;
    private HangSxDAO hangsx_DAO;
       
    public HANG_SX_BUS() throws IOException, ClassNotFoundException, SQLException{
        this.hangsx_DAO = new HangSxDAO();
        readHANG_SX_BUS();
    }
    
    public void readHANG_SX_BUS() throws IOException{
        this.hangsx = hangsx_DAO.readData();
    }
    
    //Hàm thêm hãng sản xuất
    public boolean addHANG_SX_BUS(Hang_SX data){
        hangsx.add(data);
        if(hangsx_DAO.writeData(data) == true){
            return true;
        } else return false;
    }
    
    //Hàm xóa hãng sản xuất
    public boolean deleteHANG_SX_BUS(String ma){
        ma = ma.trim().toLowerCase();
        for(Hang_SX hang : hangsx){
            if(hang.getMaHang().trim().toLowerCase().equals(ma)){
                hangsx.remove(hang);
                if(hangsx_DAO.deleteData(ma) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Hàm sửa hãng sản xuất
    public boolean updateHANG_SX_BUS(Hang_SX data){
        String ma = data.getMaHang();
        int i=0;
        ma = ma.trim().toLowerCase();
        for(Hang_SX hang : hangsx){
            hangsx.set(i, data);
            if(hang.getMaHang().trim().toLowerCase().equals(ma)){
                if(hangsx_DAO.updateData(data) == true){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
