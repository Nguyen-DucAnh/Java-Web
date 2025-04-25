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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.User;

/**
 *
 * @author Đông
 */
@WebServlet(name = "EditProfile", urlPatterns = {"/editprofile"})
public class EditProfile extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String fName = request.getParameter("fname");
            String lName = request.getParameter("lName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String source = request.getParameter("source");
            String ms ="";
            
            
            // Kiểm tra giá trị nhập vào
            
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (email == null || !email.matches(emailRegex)) {
                ms="Invalid email number format(ex:abc@gmail.com)";
                request.setAttribute("ms", ms);
                request.getRequestDispatcher("addProfile.jsp").forward(request, response);
                request.getRequestDispatcher("editProfile.jsp").forward(request, response);
                return;
            }
            String phoneRegex = "^[0-9]{10,15}$"; // Điều chỉnh theo định dạng bạn muốn
            if (phone == null || !phone.matches(phoneRegex)) {
                ms="Invalid phone number format(123-456-7890)";
                request.setAttribute("ms", ms);
                request.getRequestDispatcher("addProfile.jsp").forward(request, response);
                request.getRequestDispatcher("editProfile.jsp").forward(request, response);
                return;
            }

            DAO dao = new DAO();
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            int sid = a.getId();

            // Thực hiện thêm hoặc cập nhật người dùng
            if ("add".equals(source)) {
                dao.insertUser(sid, fName, lName, email, phone);
            } else if ("edit".equals(source)) {
                dao.updateUser(fName, lName, email, phone, sid);
            }

            request.getRequestDispatcher("profilecontrol").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
           
        }
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
