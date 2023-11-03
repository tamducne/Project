/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.project.project1.controller.user;

import com.project.project1.constant.Constant;
import com.project.project1.dal.impl.AccountDAO;
import com.project.project1.entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TAMDUC
 */
public class DashboardServletUser extends HttpServlet {

    AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page") == null ? "" : request.getParameter("page");
        String url;
        switch (page) {
            case "profile":
                url = "view/user/dashboard/profile.jsp";
                break;
            case "purchase":
                url = "";
                break;
            case "change-password":
                url = "";
                break;
            default:
                url = "view/user/dashboard/dashboard.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        String url = "";
        switch (action) {
            case "profile":
                UpdateProfileDoPost(request);
                url = "view/user/dashboard/profile.jsp";
                break;
            default:
                url = "dashboard";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    private void UpdateProfileDoPost(HttpServletRequest request) {
        //lấy về thông tin cần update
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        Account account = Account.builder()
                .username(username)
                .email(email)
                .address(address)
                .build();
        accountDAO.updateProfile(account);
        //update lại account vào sesion
        HttpSession session = request.getSession();
        Account accountNew = (Account)session.getAttribute(Constant.SESSION_ACCOUNT);
        accountNew.setEmail(email);
        accountNew.setAddress(address);
        session.setAttribute(Constant.SESSION_ACCOUNT, accountNew);
    }

}
