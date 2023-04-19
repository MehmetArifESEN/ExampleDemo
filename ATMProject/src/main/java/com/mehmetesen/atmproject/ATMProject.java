/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mehmetesen.atmproject;

import com.mehmetesen.atmproject.entity.User;
import com.mehmetesen.atmproject.repository.AccountRepository;
import com.mehmetesen.atmproject.repository.UserRepository;

/**
 *
 * @author mehme
 */
public class ATMProject {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        AccountRepository accountRepository = new AccountRepository();
        
        User user = userRepository.login("a@gmail.com", "123");
        //System.out.println(user.getId());
        accountRepository.createAccount(user);
        //System.err.println(user.getEmail());
    }
}
