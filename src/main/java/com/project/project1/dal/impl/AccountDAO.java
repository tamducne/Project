/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project1.dal.impl;

import com.project.project1.constant.Constant;
import com.project.project1.dal.GenericDAO;
import com.project.project1.entity.Account;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TAMDUC
 */
public class AccountDAO extends GenericDAO<Account> {

    public Account findByUsernamePassword(Account account) {
        String sql = "SELECT * FROM [Account]\n"
                + "WHERE username = ? and password = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", account.getUsername());
        parameterMap.put("password", account.getPassword());

        List<Account> list = queryGenericDAO(Account.class, sql,
                parameterMap);
        return list.isEmpty()
                ? null
                : list.get(0);
    }

    @Override
    public List<Account> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Account t) {
        return insertGenericDAO(t);
    }

    public boolean findByUsername(String username) {
        String sql = "SELECT * FROM [Account]\n"
                + "WHERE username = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", username);
        List<Account> list = queryGenericDAO(Account.class, sql,
                parameterMap);
        return !list.isEmpty();
    }

    public void updateProfile(Account account) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [email] = ?\n"
                + "      ,[address] = ?\n"
                + " WHERE username = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("email", account.getEmail());
        parameterMap.put("address", account.getAddress());
        parameterMap.put("username", account.getUsername());
        updateGenericDAO(sql, parameterMap);
        
    }

}
