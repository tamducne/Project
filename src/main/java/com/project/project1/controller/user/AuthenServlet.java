/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.project.project1.controller.user;

import com.project.project1.constant.Constant;
import com.project.project1.dal.impl.AccountDAO;
import com.project.project1.entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TAMDUC
 */
public class AuthenServlet extends HttpServlet {

    AccountDAO accountDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url;
//        get action
        String action = request.getParameter("action") == null ? "login"
                : request.getParameter("action");
        //switch action
        switch (action) {
            case "login":
                //url login.jsp
                url = "view/user/home-page/login.jsp";
                break;
            case "register":
                url = "view/user/home-page/register.jsp";
                break;
            case "logout":
                logoutDoGet(request, response);
                url = "home";
                break;
            default:
                url = "login";
                break;

        }

        request.getRequestDispatcher(url).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get action
        String action = request.getParameter("action") == null ? "login"
                : request.getParameter("action");
        //switch action
        switch (action) {
            case "login":
                loginDoPost(request, response);
                break;
            case "register":
                registerDoPost(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void loginDoPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tạo đối tượng Account
        accountDAO = new AccountDAO();
        //get về các thông tin
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = Account.builder()
                .username(username)
                .password(password)
                .build();
        //kiểm tra xem database cái login có đúng hay không

        //tồn tại chuyển qua trang dashboard hoặc báo lỗi ở login
        account = accountDAO.findByUsernamePassword(account);
        if (account == null) {
            request.setAttribute("error", "Username or password incorrect");
            request.getRequestDispatcher("view/user/home-page/login.jsp").forward(request, response);

        } else {
            //set vao session account
            HttpSession session = request.getSession();
            session.setAttribute(Constant.SESSION_ACCOUNT, account);
            //chuyển về trang home
            response.sendRedirect("home");
        }
    }

    private void logoutDoGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constant.SESSION_ACCOUNT);
    }

    private void registerDoPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //khai báo đối tượng
        accountDAO = new AccountDAO();
        //get information
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        Account account = Account.builder()
                .username(username)
                .password(password)
                .email(email)
                .roleid(Constant.ROLE_USER)
                .build();
        
        // kiểm tra nó có tồn tại ở trong db chưa
        boolean isExit = accountDAO.findByUsername(username);
        if (!isExit) {
            //nếu chếua từng tồn tại thì insert vào dtb
            accountDAO.insert(account);
            //chuyển về trang home
            response.sendRedirect("home");
            
        }else{
        //chuyển về trang home
        request.setAttribute("error", "Account exist, please choose other !!");
            request.getRequestDispatcher("view/user/home-page/register.jsp").forward(request, response);
        }
        
        //
    }

}
