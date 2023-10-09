/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.project.project1.controller.user;

import com.project.dal.GenericDAO;
import com.project.dal.impl.DepartmentDAO;
import com.project.dal.impl.DoctorDAO;
import com.project.entity.Department;
import com.project.entity.Doctor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TAMDUC
 */
public class HomeServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDAO<Doctor> doctorDAO = new DoctorDAO();
        GenericDAO<Department> departmentDAO = new DepartmentDAO();
        HttpSession session = request.getSession();
        //go to hompage
        List<Doctor> listDoctor = doctorDAO.findAll();
        List<Department> listDepartment = departmentDAO.findAll();
        session.setAttribute("listDoctor", listDoctor);
        session.setAttribute("listDepartment", listDepartment);
        request.getRequestDispatcher("view/user/home-page/homePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }


}
