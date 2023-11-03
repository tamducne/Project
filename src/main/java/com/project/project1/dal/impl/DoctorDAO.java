/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project1.dal.impl;

import com.project.project1.constant.Constant;
import com.project.project1.dal.GenericDAO;
import com.project.project1.entity.Doctor;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author TAMDUC
 */
public class DoctorDAO extends GenericDAO<Doctor> {

    @Override
    public List<Doctor> findAll() {
        return queryGenericDAO(Doctor.class);

    }

    public static void main(String[] args) {
        for (Doctor doctor : new DoctorDAO().findAll()) {
            System.out.println(doctor);
        }
    }

    public List<Doctor> findContainsByProperty(String field, String keyword) {
        String sql = "select * from Doctor \n"
                + "where " + field + " like ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("name", "%" + keyword + "%");
        return queryGenericDAO(Doctor.class, sql, parameterMap);
    }

    public List<Doctor> findByProperty(String field, String id) {
        String sql = "select * from Doctor where " + field + " = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("departmentid", id);
        return queryGenericDAO(Doctor.class, sql, parameterMap);
    }

    public List<Doctor> findByPage(int page) {
        String sql = "select * from Doctor\n"
                + "order by id\n"
                + "offset ? rows\n"
                + "fetch next ? rows only";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("offset", (page - 1) * Constant.RECORD_PER_PAGE);
        parameterMap.put("fetch next", Constant.RECORD_PER_PAGE);
        return queryGenericDAO(Doctor.class, sql, parameterMap);

    }

    public int findTotalRecord() {
        return findTotalRecordGenericDAO(Doctor.class);
    }

    @Override
    public int insert(Doctor doctor) {
        return insertGenericDAO(doctor);
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM [dbo].[Doctor]\n"
                + "      WHERE id = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("id", id);
        updateGenericDAO(sql, parameterMap);
    }

    public void updateDoctor(Doctor doctor) {
        String sql = "UPDATE [dbo].[Doctor]\n"
                + "   SET [name] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[departmentid] = ?\n"
                + "      ,[price] = ?\n"
                + " WHERE id = ?";
        parameterMap = new LinkedHashMap<>();

        parameterMap.put("name", doctor.getName());
        parameterMap.put("image", doctor.getImage());
        parameterMap.put("description", doctor.getDescription());
        parameterMap.put("departmentid", doctor.getDepartmentid());
        parameterMap.put("price", doctor.getPrice());

        parameterMap.put("id", doctor.getId());
        updateGenericDAO(sql, parameterMap);

    }
}
