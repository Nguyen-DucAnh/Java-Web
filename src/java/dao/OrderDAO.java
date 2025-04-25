/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conf.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.OrderStatus;

/**
 *
 * @author Nguyen Duc Anh
 */
public class OrderDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public OrderStatus getOrderStatusById(int id) {
        try {
            String query = "SELECT * FROM Order_Status\n"
                    + "WHERE id = ?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderStatus o = new OrderStatus(rs.getInt(1), rs.getString(2));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
