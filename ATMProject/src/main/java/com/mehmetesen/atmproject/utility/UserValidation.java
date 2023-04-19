/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mehmetesen.atmproject.utility;

/**
 *
 * @author mehme
 */
public class UserValidation {
    public static boolean checkEmail(String email) {
        String sql = "select count(*) where email =?";
        if(1>0) {
            return false;
        } else {
            return true;
        }
    }
    
}
