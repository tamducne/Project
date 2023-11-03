/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.project.project1.controller.admin;

import com.project.project1.dal.impl.DepartmentDAO;
import com.project.project1.dal.impl.DoctorDAO;
import com.project.project1.entity.Department;
import com.project.project1.entity.Doctor;
import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author TAMDUC
 */
@MultipartConfig
public class DashboardServlet extends HttpServlet {

    DoctorDAO doctorDAO;
    DepartmentDAO departmentDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //tạo ra đối tượng DAO
        doctorDAO = new DoctorDAO();
        departmentDAO = new DepartmentDAO();
        //tìm về toàn bộ danh sách bác sĩ
        HttpSession session = request.getSession();
        List<Doctor> listDoctor = doctorDAO.findAll();
        List<Department> listDepartment = departmentDAO.findAll();
        //chuyển qua trang dashboard.jsp
        session.setAttribute("listDoctor", listDoctor);
        session.setAttribute("listDepartment", listDepartment);
        //hiện tại đang ở dashboard đường dân admin/dashboard
        request.getRequestDispatcher("../view/admin/dashboard/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set enconding UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //TAO SESSION
        HttpSession session = request.getSession();
        String action = request.getParameter("action") == null
                ? ""
                : request.getParameter("action");
        switch (action) {
            case "add":
                addDoctor(request);
                break;
            case "delete":
                delete(request);
                break;
            case "edit":
                edit(request);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("dashboard");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addDoctor(HttpServletRequest request) {
        //tạo đối tượng DAO
        doctorDAO = new DoctorDAO();
        //get information
        //get name
        String name = request.getParameter("name");
        //get price
        int price = Integer.parseInt(request.getParameter("price"));

        //get description
        String description = request.getParameter("description");
        //get category Id
        int departmentid = Integer.parseInt(request.getParameter("department"));
        String imagePath = null;
        try {
            Part part = request.getPart("image");

            //đường dẫn lưu ảnh
            String path = request.getServletContext().getRealPath("/images");
            File dir = new File(path);
            //ko có đường dẫn => tự tạo ra
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File image = new File(dir, part.getSubmittedFileName());
            part.write(image.getAbsolutePath());
            System.out.println(image.getAbsolutePath());
            
            imagePath = "/Project1/images/" + image.getName();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Doctor doctor = Doctor.builder()
                .name(name)
                .price(price)
                .description(description)
                .departmentid(departmentid)
                .image(imagePath)
                .build();
        doctorDAO.insert(doctor);
    }

    private void delete(HttpServletRequest request) {
        
        doctorDAO = new DoctorDAO();
        //get information
        int id = Integer.parseInt(request.getParameter("id"));
        //delete book by id
        doctorDAO.deleteById(id);

    }

    private void edit(HttpServletRequest request) {
        Doctor doctor = new Doctor();
        //get information
        //getid
        int id = Integer.parseInt(request.getParameter("id")) ;
        //get name
        String name = request.getParameter("name");
        //get price
        int price = Integer.parseInt(request.getParameter("price"));

        //get description
        String description = request.getParameter("description");
        //get category Id
        int departmentid = Integer.parseInt(request.getParameter("department"));
        String imagePath = null;
        try {

            Part part = request.getPart("image");
            if (part == null || part.getSize() <= 0) {
                // Sử dụng ảnh hiện tại và cập nhật đường dẫn (imagePath)
                String currentImage = request.getParameter("currentImage");
                doctor.setImage(currentImage);
            } else {
                try {
                    String path = request.getServletContext().getRealPath("/images");
                    File dir = new File(path);
                    //ko có đường dẫn => tự tạo ra
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }

                    File image = new File(dir, part.getSubmittedFileName());
                    part.write(image.getAbsolutePath());
                    imagePath = "/Project1/images/" + image.getName();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        doctor.setId(id);
        doctor.setName(name);
        doctor.setPrice(price);
        doctor.setDescription(description);
        doctor.setImage(imagePath);
        doctor.setDepartmentid(departmentid);

        DoctorDAO dao = new DoctorDAO();
        dao.updateDoctor(doctor);
    }

}
