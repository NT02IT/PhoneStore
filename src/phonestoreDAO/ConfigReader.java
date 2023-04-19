/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreDAO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author duong
 */
public class ConfigReader {
    public static void readConfig() throws IOException {
        String filename = "E:\\Studying_files\\Java\\PhoneStore\\src\\phonestoreDAO\\server.txt";
        
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        String server = properties.getProperty("server");
        String database = properties.getProperty("database");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        int port = Integer.parseInt(properties.getProperty("port"));
    }
}
