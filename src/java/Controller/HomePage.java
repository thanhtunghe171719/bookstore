/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Entity.Campaigns;
import Entity.Product;
import Model.DAOCampaigns;
import Model.DAOProduct;
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
@WebServlet(name="HomePage", urlPatterns={"/HomePageURL"})
public class HomePage extends HttpServlet {
   
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
        String user = (String) session.getAttribute("user");
        request.setAttribute("user", user);

        DAOProduct daoProduct = new DAOProduct();
        DAOCampaigns daoCampaigns = new DAOCampaigns();
        
        Vector<Campaigns> vectorCampains = daoCampaigns.getAll("select * from Campaigns ORDER BY compaign_id DESC LIMIT 3");
        request.setAttribute("3campaigns", vectorCampains);

        
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAll";
        }
        if (service.equals("listAll")) {
            Vector<Product> vectorProducts = daoProduct.getAll("SELECT * FROM books WHERE discount > 0 ORDER BY discount DESC LIMIT 6;");
            request.setAttribute("6products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("index.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        
        if(service.equals("sale")){

            Vector<Product> vectorProducts = daoProduct.getAll("SELECT * FROM books WHERE discount > 0 ORDER BY discount DESC LIMIT 6;");
            request.setAttribute("6products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("index.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        
        if(service.equals("new")){
            
            Vector<Product> vectorProducts = daoProduct.getAll("SELECT * FROM books WHERE book_id > 0 ORDER BY book_id DESC LIMIT 6;");
            request.setAttribute("6products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("index.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        
        if(service.equals("sold")){
            Vector<Product> vectorProducts = daoProduct.getAll("SELECT b.book_id, b.title, b.author, b.image, b.category_id, b.published_year, b.size, \n" +
                                                                "    b.weight, b.summary, b.price, b.discount,  b.stock, b.create_at, b.update_at\n" +
                                                                "FROM books b LEFT JOIN order_items oi ON b.book_id = oi.book_id\n" +
                                                                "GROUP BY b.book_id, b.title, b.author, b.image, b.category_id, b.published_year, b.size, \n" +
                                                                "    b.weight, b.summary, b.price, b.discount, b.stock, b.create_at, b.update_at\n" +
                                                                "ORDER BY  COALESCE(SUM(oi.quantity), 0) DESC LIMIT 6;");
            request.setAttribute("6products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("index.jsp");
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
