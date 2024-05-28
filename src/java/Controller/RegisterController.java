/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Entity.users;
import Model.DAOUsers;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author TDG
 */
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DAOUsers  userDAO;

    public void init() {
        userDAO = new DAOUsers();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        

        // Check if username already exists
        users existingUser = userDAO.getUserByUsername(email);
        if (existingUser != null) {
            request.setAttribute("errorMessage", "Username already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Create a new user object
        users newUser = new users();
        newUser.setEmail(email);
        newUser.setPassword(password);
        

        // Add the new user to the database
        boolean userAdded = userDAO.addUser(newUser);

        if (userAdded) {
            // Registration successful
            request.setAttribute("error", "Register Success!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            //response.sendRedirect("login");
        } else {
            // Registration failed
            request.setAttribute("errorMessage", "Registration failed. Please try again later.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
