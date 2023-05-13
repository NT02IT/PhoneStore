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
public interface Action<A> {
    public ArrayList<A> getList();
    public ArrayList<A> read() throws IOException;
    public boolean write(A data) throws IOException;   
    public boolean delete(A data) throws IOException;   
    public boolean update(A data) throws IOException;   
    public int searchByID(String ID);
}
