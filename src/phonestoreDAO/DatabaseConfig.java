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
public class DatabaseConfig {
    //các đối tượng config
    private static String server;
    private static String database;
    private static String username;
    private static String password;
    private static int port;

    public DatabaseConfig(){
        
    }
    
    //hàm đọc các config sql server từ file txt
    public void readConfig() throws IOException {
        String filename = "E:\\Studying_files\\Java\\PhoneStore\\src\\phonestoreDAO\\server.txt";//đường dẫn đến file txt
        
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        server = properties.getProperty("server");
        database = properties.getProperty("database");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        port = Integer.parseInt(properties.getProperty("port"));
    }

    public String getServer() {
        return server;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

}
