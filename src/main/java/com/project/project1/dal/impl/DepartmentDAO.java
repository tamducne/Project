/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project1.dal.impl;

import com.project.project1.dal.GenericDAO;
import com.project.project1.entity.Department;
import java.util.List;

/**
 *
 * @author TAMDUC
 */
public class DepartmentDAO extends GenericDAO<Department>{

    @Override
    public List<Department> findAll() {
       return queryGenericDAO(Department.class);
        
    }
    public static void main(String[] args) {
        for (Department department : new  DepartmentDAO().findAll()) {
            System.out.println(department);
        }
    }

    @Override
    public int insert(Department t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
