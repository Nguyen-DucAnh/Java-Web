/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import model.VNpay;

/**
 *
 * @author Nguyen Duc Anh
 */
@WebServlet(name = "VNpayControl", urlPatterns = {"/VNpay"})
public class VNpayControl extends HttpServlet {

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
            out.println("<title>Servlet VNpayControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VNpayControl at " + request.getContextPath() + "</h1>");
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
        // Lấy số tiền từ request và nhân 100000 để phù hợp với VNPay
        double amount = Double.parseDouble(request.getParameter("amount")) * 100000;
        long vnp_Amount = (long) amount; // Ép kiểu về số nguyên 
        String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Danh sách tham số
        List<String[]> vnp_Params = new ArrayList<>();
        vnp_Params.add(new String[]{"vnp_Version", "2.1.0"});
        vnp_Params.add(new String[]{"vnp_Command", "pay"});
        vnp_Params.add(new String[]{"vnp_TmnCode", VNpay.VNP_TMN_CODE});
        vnp_Params.add(new String[]{"vnp_Amount", String.valueOf(vnp_Amount)});
        vnp_Params.add(new String[]{"vnp_CurrCode", "VND"});
        vnp_Params.add(new String[]{"vnp_TxnRef", orderId});
        vnp_Params.add(new String[]{"vnp_OrderInfo", "Thanh toán đơn hàng #" + orderId});
        vnp_Params.add(new String[]{"vnp_OrderType", "other"});
        vnp_Params.add(new String[]{"vnp_Locale", "vn"});
        vnp_Params.add(new String[]{"vnp_ReturnUrl", VNpay.RETURN_URL});
        vnp_Params.add(new String[]{"vnp_IpAddr", request.getRemoteAddr()});
        vnp_Params.add(new String[]{"vnp_CreateDate", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())});

        // Sắp xếp tham số theo tên
        vnp_Params.sort(Comparator.comparing(a -> a[0]));

        // Tạo query string
        StringBuilder query = new StringBuilder();
        StringBuilder hashData = new StringBuilder();
        for (String[] param : vnp_Params) {
            query.append(URLEncoder.encode(param[0], "UTF-8"))
                    .append('=')
                    .append(URLEncoder.encode(param[1], "UTF-8"))
                    .append('&');

            hashData.append(param[0])
                    .append('=')
                    .append(URLEncoder.encode(param[1], "UTF-8"))
                    .append('&');
        }

        // Xóa ký tự `&` cuối cùng
        String queryUrl = query.substring(0, query.length() - 1);
        String secureHash = hmacSHA512(VNpay.VNP_HASH_SECRET, hashData.substring(0, hashData.length() - 1));
        queryUrl += "&vnp_SecureHash=" + secureHash;

        // Chuyển hướng đến VNPay
        response.sendRedirect(VNpay.VNPAY_URL + "?" + queryUrl);
    }

    private static String hmacSHA512(String key, String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA512");
            mac.init(secretKey);
            byte[] hash = mac.doFinal(data.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi tạo chữ ký HMAC SHA-512", e);
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
