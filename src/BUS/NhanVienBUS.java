/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Connection.MyConnection;
import DAO.NhanVienDAO;
import DTO.KhachHang;
import DTO.NhanVien;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author agond
 */
public class NhanVienBUS{
    private ArrayList<NhanVien> list;    
    private int soLuong = 0;
    NhanVienDAO nvDAO;
    
    public NhanVienBUS() throws ClassNotFoundException, SQLException, IOException {
        MyConnection myConn = new MyConnection();
        nvDAO = new NhanVienDAO();
        this.list = new ArrayList<>(nvDAO.getList());
    }

    public ArrayList<NhanVien> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = NhanVienDAO.getSoLuong();
        return soLuong;
    }
    
    public int write(NhanVien data, String pwdConfirm){
        if (!checkUnique(data))
            return 1; // Username bị trùng
        if (!checkPwdConfirm(data, pwdConfirm))
            return 2; // Password không trùng nhau
        nvDAO.write(data);
        list.add(data);
        return 0; // Thêm thành công        
    }
    
    public boolean delete(NhanVien data){
        String maNV = data.getMaNV().trim();
        for (NhanVien nv : list){
            if(nv.getMaNV().trim().equals(maNV)){
                if(nvDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaNV()));
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean update(NhanVien data){
        String maNV = data.getMaNV().trim();
        for (NhanVien nv : list){
            if(nv.getMaNV().trim().equals(maNV)){
                if(nvDAO.update(data)){
                    list.set(searchIndexByID(data.getMaNV()), data);
                    return true;
                }
            }
        }        
        return false;
    }
    
    public boolean resetPassword(String username, String newPwd) throws IOException{
        if (nvDAO.resetPassword(username, newPwd)){
            int indexNV = searchIndexByUsername(username);  
            list.get(indexNV).setUsername(username);     
            return true;
        }
        return false;
    }
    
    public int searchIndexByID(String ID) { // ID = MaNV
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNV().equals(ID)) {
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
            tempUsername = list.get(i).getUsername().trim();
            if (tempUsername.equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public NhanVien searchObjectByUsername(String username) {
        NhanVien result = null;
        String tempUsername;
        for(NhanVien nv : list){
            tempUsername = nv.getUsername().trim();
            if (tempUsername.equals(username.trim())){
                result = nv;  
                break;
            }
        }
        return result;
    }
    
    public boolean checkUnique(NhanVien data){
        if (searchIndexByUsername(data.getUsername()) >= 0)
            return false;
        return true;
    }
    
    public boolean checkPwdConfirm(NhanVien data, String pwdConfirm){
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
            XSSFSheet sheet = workbook.createSheet("Danh sách nhân viên");

            // Đặt tiêu đề cho các cột
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã nhân viên");
            headerRow.createCell(1).setCellValue("Họ lót");
            headerRow.createCell(2).setCellValue("Tên");
            headerRow.createCell(3).setCellValue("Địa chỉ");
            headerRow.createCell(4).setCellValue("Số điện thoại");
            headerRow.createCell(5).setCellValue("Lương");
            headerRow.createCell(6).setCellValue("Username");
            headerRow.createCell(7).setCellValue("Password");

            // Ghi dữ liệu sản phẩm vào từng dòng
            int rowNum = 1;
            for (NhanVien nv : list) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(nv.getMaNV());
                row.createCell(1).setCellValue(nv.getHoLot());
                row.createCell(2).setCellValue(nv.getTen());
                row.createCell(3).setCellValue(nv.getDiaChi());
                row.createCell(4).setCellValue(nv.getSDT());
                row.createCell(5).setCellValue(nv.getLuong());
                row.createCell(6).setCellValue(nv.getUsername());
                row.createCell(7).setCellValue(nv.getPassword());
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
