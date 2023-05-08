/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author duong
 */
public interface DataTranfer<A> {
    public ArrayList<A> getList();
    public ArrayList<A> readData() throws IOException;
    public boolean writeData(A data);
    public ArrayList<A> readDatabyKey(String key) throws IOException;
    
}
