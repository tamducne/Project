/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.dal.impl;

import com.project.dal.GenericDAO;
import com.project.entity.Doctor;
import java.util.List;

/**
 *
 * @author TAMDUC
 */
public class DoctorDAO extends GenericDAO<Doctor>{

    @Override
    public List<Doctor> findAll() {
       return queryGenericDAO(Doctor.class);
       
    }
    public static void main(String[] args) {
        for (Doctor doctor : new DoctorDAO().findAll()) {
            System.out.println(doctor);
        }
    }
    
}
