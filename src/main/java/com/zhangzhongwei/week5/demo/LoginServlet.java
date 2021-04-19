package com.zhangzhongwei.week5.demo;

import com.zhangzhongwei.Dao.UserDao;
import com.zhangzhongwei.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet ", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        try {
            UserDao userDao = new UserDao();
            User user = userDao.findByUsernamePassword(con, username, password);
            if (user != null) {
                //-demo#1
                // Cookie c=new Cookie("sessionid",""user.getId());
                // c.setMaxAge(10*60);
                // response.addCookie(c);
                String rememberMe = request.getParameter("rememberMe");
                if (rememberMe != null && rememberMe.equals("1")) {

                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session = request.getSession();
                System.out.println("session id-->" + session.getId());
                session.setMaxInactiveInterval(10);

                request.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}