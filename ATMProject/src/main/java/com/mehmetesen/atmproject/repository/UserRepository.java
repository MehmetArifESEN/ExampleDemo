/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mehmetesen.atmproject.repository;


import com.mehmetesen.atmproject.entity.User;
import com.mehmetesen.atmproject.utility.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berkin.yardimci
 */
public class UserRepository {

    public User login(String email, String password) {
        User user = null;
        String sql = "select * from users where email=? and password=?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public int getIdByEmail(String email) {
        User user = null;
        String sql = "select * from users where email=?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                return user.getId();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getIdByEmail2(User user) {
        String sql = "select * from users where email=?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                return user.getId();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
