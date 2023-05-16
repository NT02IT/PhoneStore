/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author agond
 */
public class KhachHangBUS{
    private ArrayList<KhachHang> list;    
    private int soLuong = 0;
    KhachHangDAO khDAO;
    
    public KhachHangBUS() throws ClassNotFoundException, SQLException, IOException {
        khDAO = new KhachHangDAO();
        this.list = new ArrayList<>(khDAO.getList());
    }

    public ArrayList<KhachHang> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = KhachHangDAO.getSoLuong();
        return soLuong;
    }
    
    public int write(KhachHang data, String pwdConfirm){
        if (!checkUnique(data))
            return 1; // Username bị trùng
        if (!checkPwdConfirm(data, pwdConfirm))
            return 2; // Password không trùng nhau
        khDAO.write(data);
        list.add(data);
        return 0; // Thêm thành công        
    }
    
    public boolean delete(KhachHang data){
        String maKH = data.getMaKH();
        for (KhachHang kh : list){
            if(kh.getMaKH().equals(maKH)){
                if(khDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaKH()));
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean update(KhachHang data){
        String maKH = data.getMaKH();
        for (KhachHang kh : list){
            if(kh.getMaKH().equals(maKH)){
                if(khDAO.update(data)){
                    list.set(searchIndexByID(data.getMaKH()), data);
                    return true;
                }
            }
        }        
        return false;
    }

    public boolean resetPassword(String username, String newPwd) throws IOException{
        if (khDAO.resetPassword(username, newPwd)){
            int indexKH = searchIndexByUsername(username);  
            list.get(indexKH).setUsername(username);     
            return true;
        }
        return false;
    }
    
    public int searchIndexByID(String ID) { // ID = MaKH
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKH().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int searchIndexByUsername(String username) {
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        String tempUsername;
        for(int i = 0; i < list.size(); i++){
            tempUsername = list.get(i).getUsername();
            if (tempUsername.equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public KhachHang searchObjectByUsername(String username) {
        KhachHang result = null;
        String tempUsername;
        for(KhachHang kh : list){
            tempUsername = kh.getUsername();
            if (tempUsername.equals(username)){
                result = kh;  
                break;
            }
        }
        return result;
    }
    
    public boolean checkUnique(KhachHang data){
        if (searchIndexByUsername(data.getUsername()) >= 0)
            return false;
        return true;
    }
    
    public boolean checkPwdConfirm(KhachHang data, String pwdConfirm){
        if (pwdConfirm.equals(data.getPassword()))
            return true;
        return false;
    }
    
    //Hàm nếu lưu file thành công trả về true
    public boolean export_excel(){
        JFileChooser file = new JFileChooser();
        file.setDialogTitle("Lưu file excel");
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File Excel (*.xlsx)", "xlsx");
        file.setFileFilter(filter);
        
        int userSelection = file.showSaveDialog(null);
        
        if(userSelection == JFileChooser.APPROVE_OPTION){
            String filePath = file.getSelectedFile().getAbsolutePath();
            System.out.println(filePath);
            if(!filePath.toLowerCase().endsWith(".xlsx")){
                filePath += ".xlsx";
            }
            saveToFile(filePath);
            return true;
        } else return false;
    }
    
    //Hàm thực hiện đưa dữ liệu vào file và tạo file
    private void saveToFile(String filePath){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            // Tạo một trang trong workbook
            XSSFSheet sheet = workbook.createSheet("Danh sách sản phẩm");

            // Đặt tiêu đề cho các cột
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã khách hàng");
            headerRow.createCell(1).setCellValue("Họ lót");
            headerRow.createCell(2).setCellValue("Tên");
            headerRow.createCell(3).setCellValue("Địa chỉ");
            headerRow.createCell(4).setCellValue("Số điện thoại");
            headerRow.createCell(5).setCellValue("Username");
            headerRow.createCell(6).setCellValue("Password");

            // Ghi dữ liệu sản phẩm vào từng dòng
            int rowNum = 1;
            for (KhachHang kh : list) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(kh.getMaKH());
                row.createCell(1).setCellValue(kh.getHoLot());
                row.createCell(2).setCellValue(kh.getTen());
                row.createCell(3).setCellValue(kh.getDiaChi());
                row.createCell(4).setCellValue(kh.getSDT());
                row.createCell(5).setCellValue(kh.getUsername());
                row.createCell(6).setCellValue(kh.getPassword());
            }

            // Tạo file và ghi dữ liệu ra file
            try (FileOutputStream fileOut = new FileOutputStream(new File(filePath.toString()))) {
                System.out.println(fileOut);
                workbook.write(fileOut);
                workbook.close();
                fileOut.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
