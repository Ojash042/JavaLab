package com.example.webapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",value = "login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("username").equals("admin"));
        if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")){
            session.setAttribute("username", "admin");
            session.setAttribute("password", "password");
        }
        response.sendRedirect("http://localhost:8080/webApp_war_exploded");
    }
}
