package com.zhangzhongwei.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("i am in  constructor --> LifeCycleServlet()");//line 1
    }
    @Override
    public void init(){
        System.out.println("i am in init() ");//line 2
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service() --> doGet()");//line 3
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy(){
        System.out.println("i am in destroy() ");//when ?
    }
}
