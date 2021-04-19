package com.zhangzhongwei.week3.demo;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebService
public class RegisterServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        try {
            Statement st = con.createStatement();
            String birthdate;
            String sql = "insert into  usertable(username,password,email,gender,birthdate)" +
                    "values(" + username + ",'" + password + "','" + email + "','" + gender + "','" + birthDate + "')";
            System.out.println(sql);
            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);
            sql = "select id, username,password,email,birthday from usertable";
            ResultSet rs = st.executeQuery(sql);
            PrintWriter out = response.getWriter();
            //out.println("<html><tittle></tittle><body><table border=1><tr>");
            //out.println("<td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td><tr>");
            /*while(rs.next()){
                //get one by one
                out.println("<tr>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthday")+"</td>");
                out.println("</tr>");
                }
             */
            request.getRequestDispatcher("userList.jsp");
            System.out.println("i am in RegisterSServlet-->doPost()--> after forward()");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
