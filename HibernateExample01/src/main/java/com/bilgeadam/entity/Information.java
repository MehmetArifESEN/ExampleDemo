package com.bilgeadam.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Information {

    /*

    Information sınfını veritabanında tablo olarak kullanmak ıstemıyorum
    ama bu sınıfı user sınıfıfnın ıcınde kullanmak ıstıyorum
     */
    private String name;
    private String surname;

    private String middleName;

    public Information() {
    }

    public Information(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
