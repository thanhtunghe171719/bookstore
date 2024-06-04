/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Entity.users;
import Model.DAOUsers;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author TDG
 */
@WebServlet(name="ChangePassWord", urlPatterns={"/ChangePassWordURL"})
public class ChangePassWord extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);        
        users user = (users) session.getAttribute("user");
        
        if(user == null || user.getEmail() == null){
            response.sendRedirect("LoginController");
            return; // Stop further processing
        }
        
        DAOUsers daoUser = new DAOUsers();
        
        Vector<users> userVector = daoUser.getAll("SELECT * FROM checksql.users where email like '"+user.getEmail()+"';");
        request.setAttribute("userVector", userVector);
        user = userVector.get(0);
        
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAll";
        }
        if (service.equals("listAll")) {
            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("ChangePassWord.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        if(service.equals("changePassWord")){
            String message = null;
            String submit = request.getParameter("submit");
            if(submit != null && submit.compareTo("save")==0){
                String oldPassword = request.getParameter("oldPassword");
                
                // Giải mã mật khẩu đã mã hóa
                String decodedPassword = hashPassword(oldPassword);
                              
                if(decodedPassword.equals(user.getPassword())){
                    String newPassword = request.getParameter("newPassword");
                    
                    // Mã hóa mật khẩu mới
                    String encoded = hashPassword(newPassword);
                    
                    user.setPassword(encoded);
                    int result = daoUser.changePassWord(user);
                    if(result != 0 ) {
                        message = "Change Password change successful.";
                    } else {
                        message = "Change Password change failed.";
                    }
                }else{
                    message = "INPUT OLD PASSWORD WRONG.";
                }
            }
            request.setAttribute("message", message);
            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("ChangePassWord.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        
    } 
    
    
    // Phương thức để mã hóa mật khẩu bằng SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
