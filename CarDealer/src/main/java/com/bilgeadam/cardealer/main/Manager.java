/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilgeadam.cardealer.main;

import com.bilgeadam.cardealer.entity.Car;
import com.bilgeadam.cardealer.repository.CarRepository;
import com.bilgeadam.cardealer.repository.DealershipRepository;
import com.bilgeadam.cardealer.util.Constant;
import com.bilgeadam.cardealer.util.DbConnection;
import com.bilgeadam.cardealer.util.FileUtils;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Repository katmanı ICrud interface oluşturalım, generic oluşturalım
 * yapcagımız işlemleri tanımlayalım
 *
 */
public class Manager {

    Scanner scanner = new Scanner(System.in);
    private final CarRepository carRepository = new CarRepository();
    private final DealershipRepository dealershipRepository = new DealershipRepository();

    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.menu();

    }

    public void menu() {

        int input = 0;
        do {
            System.out.println("0-çıkış");
            System.out.println("1-Cars dosyadan veritabanına kaydet");
            System.out.println("2-Araba Ekle");
            System.out.println("3-Araba Güncelle");
            System.out.println("4-Araba Sil");
            System.out.println("5-Arabaları listele");
            System.out.println("6-DealerShipsleri dosyadan veritabanına kaydet");
            input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    if (carRepository.databaseControl()) {
                        System.out.println("Veri tabanına veriler zaten kaydedilmiş durumda");
                    } else {
                        carRepository.saveAll(FileUtils.getCarList(FileUtils.readFile(Constant.carFile)));
                        System.out.println("Veriler Başarıyla kaydedildi");
                    }
                    break;
                default:
                    System.out.println("sayı girin");
                case 2:
                    carRepository.save(getCarInformation());
                case 3:
                    System.err.println("güncellemek istediğiniz arabnın idsini girin");
                    long updateId = Long.parseLong(scanner.nextLine());
                    carRepository.update(getCarInformation(), updateId);
                case 4:
                    System.err.println("silmek istediğiniz arabnın idsini girin");
                    long deletedetId = Long.parseLong(scanner.nextLine());
                    carRepository.delete(deletedetId);
                case 5:
                    carRepository.findAll().forEach(x -> System.out.println(x.toString()));
                case 6:
                    if (dealershipRepository.databaseControl()) {
                        System.out.println("Veri tabanına veriler zaten kaydedilmiş durumda");
                    } else {
                        dealershipRepository.saveAll(FileUtils.getDealershipList(FileUtils.readFile(Constant.dealershipFile)));
                        System.out.println("Veriler Başarıyla kaydedildi");
                    }
                    break;
            }
        } while (true);
    }

    public Car getCarInformation() {
        System.out.println("Lütfen Araba Markası girin");
        String brand = scanner.nextLine();

        System.out.println("Lütfen Araba Modelini girin");
        String carModel = scanner.nextLine();

        System.out.println("Lütfen Araba Yılını girin");
        String modelYear = scanner.nextLine();

        System.out.println("Lütfen Arabanın delar id sini girin");
        Long dealershipId = Long.parseLong(scanner.nextLine());

        return new Car(brand, carModel, modelYear, dealershipId);
    }
}
