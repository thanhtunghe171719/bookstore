package controller;

import dal.DBContext;
import java.io.IOException;
import java.util.ArrayList;
import model.Books;
import model.Categories;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();

        String searchText = request.getParameter("search");
        String indexPage = request.getParameter("index");
        int index = (indexPage == null) ? 1 : Integer.parseInt(indexPage);

        String sort = request.getParameter("sort");
        if (sort == null) {
            sort = "default";
        }

        String categoryidParam = request.getParameter("categoryid");
        int categoryid = (categoryidParam == null) ? 0 : Integer.parseInt(categoryidParam);

        ArrayList<Books> lst_books;
        int totalBooks;

        if (searchText != null && !searchText.isEmpty()) {
            lst_books = db.getBookBySearch(searchText);
            totalBooks = lst_books.size();
        } else {
            if (categoryid == 0) {
                lst_books = db.getListBooks(index, sort);
                totalBooks = db.getTotalBooks();
            } else {
                lst_books = db.getListBooksByCategory(categoryid, index, sort);
                totalBooks = db.getTotalBooksByCategory(categoryid);
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

    @Override
    public String getServletInfo() {
        return "Search Control Servlet";
    }
}
