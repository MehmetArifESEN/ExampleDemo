/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berkin.yardimci
 */
public class DbConnection {

    private Connection connection;
    private static DbConnection instance;
    
    public DbConnection(){
        createConnection();
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    public static DbConnection getInstance(){
        if(instance == null){
            instance = new DbConnection();
        }else{
            try{
                if(instance.getConnection().isClosed()){
                    instance= new DbConnection();
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return instance;
    }

    public Connection createConnection() {

        try {
            connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
            System.out.println("Bağlantı Başarılı");
        } catch (SQLException ex) {
            System.out.println("Bağlantı hatası");
        }
        return connection;
    }
}
