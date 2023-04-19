/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mehmetesen.atmproject.repository;

import com.mehmetesen.atmproject.entity.Account;
import com.mehmetesen.atmproject.entity.User;
import com.mehmetesen.atmproject.utility.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author berkin.yardimci
 */
public class AccountRepository {

    UserRepository userRepository;

    public AccountRepository() {
        userRepository = new UserRepository();
    }

    public void createAccount(User user) {
        String sql = "insert into accounts (account_no, user_id) values(?,?)";

        int id = userRepository.getIdByEmail(user.getEmail());
        Account account = new Account(user.getId());
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getAccountNo());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Account> getAccountByEmail(String email) {
        List<Account> accounts = new ArrayList<>();
        String sql = "select * from users join accounts on users.id = accounts.user_id where users.email=?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int balance = resultSet.getInt("balance");
                String accountNo = resultSet.getString("account_no");
                Account account = new Account();
                account.setAccountNo(accountNo);
                account.setBalance(balance);
                accounts.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public void transferMoney(int amount, String accountNo) {
        String sql = "update accounts set balance = balance + ? where account_no = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {

            connection = DbConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, accountNo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}