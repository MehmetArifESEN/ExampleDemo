package com.bilgeadam.entity;


import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
name
surname
username-->unique olsu n null olmasın
password--> null olmasın uzunlugu 32 olsun

user sınıfın ıcınde lıste ıcınde ınterests

AdressType --> Enum Home,Business, Other
Adress--> street, country ,city
Hashmap yapısında userin içinde kullanalım
 */
@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false,length = 32)
    private String password;

    @Embedded
    private Information information;

    @Enumerated(EnumType.STRING)
    private EGender eGender;

    @ElementCollection
    private List<String> interests;

    @ElementCollection
    private Map<AddressType,Address> adders;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;

        this.username = username;
        this.password = password;
    }

    public User( String username, String password,Information information,EGender eGender,List<String> interests,Map<AddressType,Address> adders) {

        this.username = username;
        this.password = password;
        this.information=information;
        this.eGender=eGender;
        this.interests= interests;
        this.adders=adders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +

                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
