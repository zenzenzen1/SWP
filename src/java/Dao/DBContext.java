package Dao;

import Model.User;
import Util.AppSetting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class DBContext {

    public Connection connection;

    public DBContext() {
         try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:mysql://localhost:3306/" + AppSetting.databaseName;
            String username = AppSetting.databaseUserName;
            String password = AppSetting.databasePassword;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
//        MD5 md5 =new MD5();
//        System.out.println(md5.getMd5("089215d197f452e4cbcd051774a4339d"));
        DBContext context = new DBContext();
        try {
            context.connection.isValid(100);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error at connecting to db");
        }
    }
}
