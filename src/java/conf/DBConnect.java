/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nguyen Duc Anh
 */
public class DBConnect {
    
    static String dbUser = "sa";
    static String dbPass = "4122004";
    static String 
    dbUrl = "jdbc:sqlserver://DUCANH:1433;databaseName=Web1;encrypt=true;trustServerCertificate=true;integratedSecurity=false";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
       
}
