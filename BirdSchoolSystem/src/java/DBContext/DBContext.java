/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DBContext {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/BirdSchoolSystem";
        String username = "sa";
        String password = "12346";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to database");
        } catch (Exception e) {
            System.out.println("Connected error: " + e.getMessage());
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return connection;
    }
}
