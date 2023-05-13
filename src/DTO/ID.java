/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author agond
 */
public class ID{
    private int max;
    private String filename;
    Properties props = null;

    public ID(String objectName) throws FileNotFoundException, IOException{
        this.filename = "src\\DTO\\MaxID.txt";
        this.props = new Properties();
        
        props.load(new FileReader(filename));
        max = Integer.parseInt(props.getProperty(objectName)); // Ghi giá trị max vào biến max       
        
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            props.load(inputStream);
            // Set new value for the property
            props.setProperty(objectName, Integer.toString(max+1));

            try (FileOutputStream outputStream = new FileOutputStream(new File(filename))) {
                props.store(outputStream, null);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        max--;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }
}

