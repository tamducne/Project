/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.project.project1.controller.user;

import com.project.project1.constant.Constant;
import com.project.project1.dal.impl.DoctorDAO;
import com.project.project1.entity.Department;
import com.project.project1.dal.impl.DepartmentDAO;
import com.project.project1.entity.Doctor;
import com.project.project1.entity.PageControl;
import java.io.IOException;
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

    DoctorDAO doctorDAO;
    DepartmentDAO departmentDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doctorDAO = new DoctorDAO();
        departmentDAO = new DepartmentDAO();
        PageControl pageControl = new PageControl();

        //go to hompage
        List<Doctor> listDoctor = null;
        List<Department> listDepartment = departmentDAO.findAll();
        HttpSession session = request.getSession();
//getaction
        String action;
        try {
            action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

        } catch (Exception e) {
            action = "";
        }
        switch (action) {
            case "pagination":
                listDoctor = pagination(request, response, pageControl);
                break;
            default:
                listDoctor = pagination(request, response, pageControl);
                break;
        }

        session.setAttribute("listDoctor", listDoctor);
        session.setAttribute("listDepartment", listDepartment);
        request.setAttribute("pageControl", pageControl);
        request.getRequestDispatcher("view/user/home-page/homePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set encodeing
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String URL = "home";
        String action = request.getParameter("action");
        switch (action) {
            case "search":
                searchByName(request, response);
                URL = "view/user/home-page/homePage.jsp";
                break;
            case "department":
                searchByDepartment(request, response);
                URL = "view/user/home-page/homePage.jsp";

                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher(URL).forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        //get keyword
        String keyword = request.getParameter("keyword");
        //tạo ra boolDAO
        doctorDAO = new DoctorDAO();
        //get doctor byname
        List<Doctor> list = doctorDAO.findContainsByProperty("name", keyword);
        //set list vao session
        HttpSession session = request.getSession();
        session.setAttribute("listDoctor", list);
    }

    private void searchByDepartment(HttpServletRequest request, HttpServletResponse response) {
        //get category id
        String id = request.getParameter("id");
        //tạo ra DoctorDAO
        doctorDAO = new DoctorDAO();
        //tìm kiếm doctors dựa trên category Id
        List<Doctor> list = doctorDAO.findByProperty("departmentid", id);
        //set list vào trong session
        HttpSession session = request.getSession();
        session.setAttribute("listDoctor", list);
    }

    private List<Doctor> pagination(HttpServletRequest request,
            HttpServletResponse response,
            PageControl pageControl) {
        //get page
        String pageRaw = request.getParameter("page");
        doctorDAO = new DoctorDAO();
        //valid page
        int page;
        try {
            page = Integer.parseInt(pageRaw);
        } catch (Exception e) {
            page = 1;
        }
        //tìm kiếm xem có bao nhiêu record
        int totalRecord = doctorDAO.findTotalRecord();

        //tìm kiếm bao nhiêu page
        int totalPage = (totalRecord % Constant.RECORD_PER_PAGE) == 0
                ? (totalRecord / Constant.RECORD_PER_PAGE)
                : (totalRecord / Constant.RECORD_PER_PAGE) + 1;
        //set vao pageControl
        pageControl.setPage(page);
        pageControl.setTotalPage(totalPage);
        pageControl.setTotalRecord(totalRecord);
        return doctorDAO.findByPage(page);

    }

}
