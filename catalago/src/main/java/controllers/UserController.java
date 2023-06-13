package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserController", urlPatterns = "/user")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isValidUser = validateUser(username, password);

        
        if (isValidUser) {
            response.sendRedirect(request.getContextPath() + "/catalog");
        } else {
            
            response.sendRedirect(request.getContextPath() + "/loginError.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    private boolean validateUser(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}
