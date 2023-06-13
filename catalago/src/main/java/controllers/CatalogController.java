package controllers;

import managers.CareerManager;
import models.Career;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CatalogController", urlPatterns = "/catalog")
public class CatalogController extends HttpServlet {
    private CareerManager careerManager;

    public void init() throws ServletException {
        Connection connection = getConnection();
        careerManager = new CareerManager(connection);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        
            List<Career> careers = careerManager.getAllCareers();

            request.setAttribute("careers", careers);
        
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    private Connection getConnection() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/enrollments";
            String username = "root";
            String password = "1234";
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Failed to connect to database: " + e.getMessage());
        }
    }
}

