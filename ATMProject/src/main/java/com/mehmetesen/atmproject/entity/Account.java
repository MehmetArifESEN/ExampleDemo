
package com.mehmetesen.atmproject.entity;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author mehme
 */
public class Account {
    private int id;
    private String accountNo;
    private int userId;
    private Date joinedDate;
    private int balance;
    private Date transactionDate;
    
   public Account(int userId) {
       this.accountNo=generateRandomAccountNo();
       
   } 

    public Account() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    private String generateRandomAccountNo() {
        //10 haneli bir account no olusturmak
        //Stringbuilder kullanalım
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
    /*
    public static String generateWalletAdress() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
       }
*/
}
