package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Books;
import model.Categories;

/**
 *
 * @author ngdin
 */
public class vanhoc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vanhoc</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet vanhoc at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();

        int totalBooks = db.getTotalBooks();
        int page = totalBooks / 3;
        
        if(totalBooks % 3 != 0){
            page++;
        }
        
        ArrayList<Books> lst_books = db.getListBooksByCategory();
        ArrayList<Categories> lst_categories = db.getListCategories();

        String sortOrder = request.getParameter("sort");
        if (sortOrder == null) {
            sortOrder = "normal";
        }

        switch (sortOrder) {
            case "normal":
                break;
            case "newest":
                Collections.sort(lst_books, (b1, b2) -> b2.getCreate_at().compareTo(b1.getCreate_at()));
                break;
            case "price-asc":
                Collections.sort(lst_books, (b1, b2) -> Double.compare(Double.parseDouble(b1.getPrice()), Double.parseDouble(b2.getPrice())));
                break;
            case "price-desc":
                Collections.sort(lst_books, (b1, b2) -> Double.compare(Double.parseDouble(b2.getPrice()), Double.parseDouble(b1.getPrice())));
                break;
            default:
                break;
        }

        request.setAttribute("page", page);
        request.setAttribute("book", lst_books);
        request.setAttribute("category", lst_categories);
        request.setAttribute("sortOrder", sortOrder);

        request.getRequestDispatcher("vanhoc.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
