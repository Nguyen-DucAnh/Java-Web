/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import model.Cart;
import model.Category;
import model.Product;

/**
 *
 * @author Nguyen Duc Anh
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

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
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listC = dao.getAllCategory();
        String txt = "";
        // lay cookie 
        Cookie[] arr = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt = o.getValue();
                }

            }
        }

        Cart cart = new Cart(txt, list);
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            dao.insertOrder(a, cart);
            Cookie c = new Cookie("cart", "");
            c.setMaxAge(0);
            response.addCookie(c);
            request.setAttribute("subtotal", cart.getTotalMoney());
            request.setAttribute("cart", cart.getListItems());
            request.setAttribute("listC", listC);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }
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
