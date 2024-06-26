/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Entity.*;
import Model.DAOPost;
import Model.DAOSlider;
import Model.DAOProduct;
import Model.DAOUsers;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.print.Book;
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
        users user = (users) session.getAttribute("user");
        
        DAOUsers daoUser = new DAOUsers();
        Vector<users> userVector = null;
        if(user != null && user.getEmail() != null){
            String email = user.getEmail();
            userVector = daoUser.getAll("SELECT * FROM checksql.users where email like '"+email+"';");
        }
        request.setAttribute("userVector", userVector);

        DAOProduct daoProduct = new DAOProduct();
        DAOSlider daoSlider = new DAOSlider();
        DAOPost daOPost = new DAOPost();
        
        Vector<Slider> vectorCampains = daoSlider.getAll("SELECT * FROM slider WHERE status = 'show' ORDER BY slider_id DESC LIMIT 3;");
        request.setAttribute("3slider", vectorCampains);

        Vector<Post> vectorPost = daOPost.getAll("SELECT * FROM posts WHERE status = 'Show' ORDER BY created_at DESC LIMIT 5;");
        request.setAttribute("5post", vectorPost);
        
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAll";
        }
        if (service.equals("listAll")) {
            Vector<Books> vectorProducts = daoProduct.getAll("SELECT * FROM books WHERE discount > 0 ORDER BY discount DESC LIMIT 5;");
            request.setAttribute("5products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("homepage.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        
        if(service.equals("sale")){

            Vector<Books> vectorProducts = daoProduct.getAll("SELECT * FROM books WHERE discount > 0 ORDER BY discount DESC LIMIT 5;");
            request.setAttribute("5products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("homepage.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        
        if(service.equals("new")){
            
            Vector<Books> vectorProducts = daoProduct.getAll("SELECT * FROM books WHERE book_id > 0 ORDER BY book_id DESC LIMIT 5;");
            request.setAttribute("5products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("homepage.jsp");
            //run(view)
            dispth.forward(request, response);
        }
        
        if(service.equals("sold")){
            Vector<Books> vectorProducts = daoProduct.getAll("SELECT b.book_id, b.title, b.author, b.image, b.category_id, b.published_year, b.size, \n" +
                                                                "    b.weight, b.summary, b.price, b.discount, b.stock, b.create_at, b.updated_at \n" +
                                                                "FROM books b LEFT JOIN order_items oi ON b.book_id = oi.book_id \n" +
                                                                "GROUP BY b.book_id, b.title, b.author, b.image, b.category_id, b.published_year, b.size, \n" +
                                                                "    b.weight, b.summary, b.price, b.discount, b.stock, b.create_at, b.updated_at \n" +
                                                                "ORDER BY COALESCE(SUM(oi.quantity), 0) DESC LIMIT 5;");
            request.setAttribute("5products", vectorProducts);

            //select(jsp)   
            RequestDispatcher dispth = request.getRequestDispatcher("homepage.jsp");
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
