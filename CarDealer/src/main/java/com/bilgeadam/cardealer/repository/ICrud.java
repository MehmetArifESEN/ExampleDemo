/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bilgeadam.cardealer.repository;

import com.bilgeadam.cardealer.entity.Car;
import com.bilgeadam.cardealer.entity.Dealership;
import java.util.List;


public interface ICrud <T>{
    
   void save(T t);
   void update(T t,long id);
   void delete(Long id);
   List<T> findAll();
   void saveAll(List<T> t);
   
   
}
