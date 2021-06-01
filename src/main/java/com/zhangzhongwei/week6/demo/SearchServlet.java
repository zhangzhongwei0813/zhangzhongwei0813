package com.zhangzhongwei.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = new String(request.getParameter("txt").getBytes(StandardCharsets.ISO_8859_1), "gbk");
        //The solution to Chinese garbled code found on the Internet does not work
        String search = request.getParameter("search");
        if ("".equals(txt.trim()))
            response.sendRedirect("index.jsp");
        else {
            if (search.equals("baidu")) {
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            } else if (search.equals("bing")) {
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            } else if (search.equals("google")) {
                response.sendRedirect("https://www.google.com/search?q=" + txt);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

