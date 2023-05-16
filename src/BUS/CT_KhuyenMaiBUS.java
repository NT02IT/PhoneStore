/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.CT_KhuyenMai;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CT_KhuyenMaiDAO;

/**
 *
 * @author agond
 */
public class CT_KhuyenMaiBUS{
    private ArrayList<CT_KhuyenMai> list;    
    private int soLuong = 0;
    CT_KhuyenMaiDAO ctkmDAO = new CT_KhuyenMaiDAO();
    
    public CT_KhuyenMaiBUS() throws ClassNotFoundException, SQLException, IOException {
        this.list = new ArrayList<>(ctkmDAO.getList());
    }

    public ArrayList<CT_KhuyenMai> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = CT_KhuyenMaiDAO.getSoLuong();
        return soLuong;
    }
    
    public int write(CT_KhuyenMai data){
        if (!checkUnique(data))
            return 1; // MaKM đã tồn tại
        ctkmDAO.write(data);
        list.add(data);
        return 0; // Thêm thành công        
    }
    
    public boolean delete(CT_KhuyenMai data){
        String maKM = data.getMaKM();
        for (CT_KhuyenMai ctkm : list){
            if(ctkm.getMaKM().equals(maKM)){
                if(ctkmDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaKM()));
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean update(CT_KhuyenMai data){
        String maKM = data.getMaKM();
        for (CT_KhuyenMai ctkm : list){
            if(ctkm.getMaKM().equals(maKM)){
                if(ctkmDAO.update(data)){
                    list.set(searchIndexByID(data.getMaKM()), data);
                    return true;
                }
            }
        }        
        return false;
    }
    
    public int searchIndexByID(String ID) { // ID = MaKM
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKM().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public CT_KhuyenMai searchObjectByID(String maKM) {
        CT_KhuyenMai result = null;
        String tempMaKM;
        for(CT_KhuyenMai ctkm : list){
            tempMaKM = ctkm.getMaKM();
            if (tempMaKM.equals(maKM))
                result = ctkm;  
                break;
        }
        return result;
    }
    
    public boolean checkUnique(CT_KhuyenMai data){
        if (searchIndexByID(data.getMaKM()) >= 0)
            return false;
        return true;
    }
    
    public CT_KhuyenMai getObjectByMaKM(String maKM){
        //CT_KhuyenMai ctkm = new CT_KhuyenMai();
        for (CT_KhuyenMai ctkm : list){
            if (ctkm.getMaKM().equals(maKM))
                return ctkm;
        }
        return null;
    }
}
