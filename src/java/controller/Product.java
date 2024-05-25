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
public class Product extends HttpServlet {

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

        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        String sort = request.getParameter("sort");
        if (sort == null) {
            sort = "default";
        }

        String categoryidParam = request.getParameter("categoryid");
        if (categoryidParam == null) {
            categoryidParam = "0";
        }

        ArrayList<Books> lst_books;
        int totalBooks = 0;

        if (categoryidParam == "0") {
            lst_books = db.getListBooks(index, sort);
            totalBooks = db.getTotalBooks();
        } else {
            try {
                int categoryid = Integer.parseInt(categoryidParam);
                lst_books = db.getListBooksByCategory(categoryid, index, sort);
                totalBooks = db.getTotalBooksByCategory(categoryid);

            } catch (NumberFormatException e) {
                // Handle the error, maybe set a default category or show an error message
                totalBooks = db.getTotalBooks();
                lst_books = db.getListBooks(index, sort); // Default behavior if parsing fails
            }
        }

        int page = (totalBooks + 2) / 3; // Round up for pagination

        ArrayList<Categories> lst_categories = db.getListCategories();

        request.setAttribute("book", lst_books);
        request.setAttribute("page", page);
        request.setAttribute("pagetag", index);
        request.setAttribute("category", lst_categories);
        request.setAttribute("sort", sort);

        request.getRequestDispatcher("product.jsp").forward(request, response);
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
