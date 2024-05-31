/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.users;
import Model.DAOUsers;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author TDG
 */
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DAOUsers userDAO;

    public void init() {
        userDAO = new DAOUsers();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Sanitize and validate input
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Email và mật khẩu không được để trống");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        users user = userDAO.getUserByUsername(email);

        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home");
        } else {
            // Authentication failed
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
