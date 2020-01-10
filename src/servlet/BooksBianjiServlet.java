package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BooksDao;
import dao.BooksDaoImpl;
import entity.Books;


public class BooksBianjiServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String id=request.getParameter("id");
    	 int i = Integer.parseInt(id); 
         BooksDao bd=new BooksDaoImpl();
         List<Books> booksSome = bd.getBooksSome(i);
         request.setAttribute("bookAll", booksSome);
         request.getRequestDispatcher("/BooksUpdate.jsp").forward(request, response);
     }
}
