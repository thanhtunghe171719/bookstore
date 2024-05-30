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
                if(oldPassword.compareTo(user.getPassword())==0){
                    String newPassword = request.getParameter("newPassword");
                    user.setPassword(newPassword);
                    int result = daoUser.changePassWord(user);
                    if(result != 0 ) {
                        message = "change Password change successful.";
                    } else {
                        message = "change Password change failed.";
                    }
                }else if(oldPassword.compareTo(user.getPassword())!=0){
                    message = "old Password change failed.";
                }
            }
            request.setAttribute("message", message);
            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("ChangePassWord.jsp");
            //run(view)
            dispth.forward(request, response);
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
