package com.example.webapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;
import java.util.UUID;

@WebServlet(name = "AddServlet", value="add")
public class AddServlet extends HttpServlet {
     public void init(){

     }
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
         PrintWriter out = response.getWriter();
         out.println("<html><body>");
         out.println("<h1>Hello World</h1>");
         out.println("</body></html>");
     }
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
         response.setContentType("text/html");
         String url;
         url = "jdbc:postgresql://localhost:5432/javaConn";
         String username ="postgres";
         String password = "postgres";
         String query;
         try {
             Class.forName("org.postgresql.Driver");
             Connection driverManager = DriverManager.getConnection(url, username, password);
             String id = UUID.randomUUID().toString();
             System.out.println(UUID.randomUUID().toString());
             System.out.println(request.toString());
             String name = request.getParameter("name");
             String mail = request.getParameter("mail");
             String phone  = request.getParameter("phone");
             query = "SELECT * FROM contact";
             query = String.format("Insert Into contact Values('%s', '%s', '%s', '%s')", id, name, mail, phone);
             Statement statement = driverManager.createStatement();
             //ResultSet resultSet= statement.executeQuery("SELECT id,name,email,phone FROM contact");
             System.out.println(query);
             statement.executeUpdate(query);
             driverManager.close();
         }
         catch (SQLException | ClassNotFoundException e){
             System.out.println(e.getMessage());
         }
         PrintWriter out = response.getWriter();

     }
}
