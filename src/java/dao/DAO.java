/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conf.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Item;

/**
 *
 * @author Nguyen Duc Anh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getListProduct() {
        try {
            String query = "SELECT TOP(8) * FROM Product\n"
                    + "Where status = 1;";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProduct() {
        try {
            String query = "SELECT * FROM Product\n"
                    + "Where status = 1;";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductByID(String id) {
        try {
            String query = "SELECT * FROM Product\n"
                    + "WHERE id =?\n"
                    + "AND status = 1";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getLastProduct() {
        try {
            String query = "SELECT TOP(4) * FROM Product\n"
                    + "Where status = 1\n"
                    + "ORDER BY id DESC";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Category> getAllCategory() {
        try {
            String query = "SELECT * FROM Category";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Category> list = new ArrayList<>();
            while (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductByCatID(String cid) {
        try {
            String query = "SELECT * FROM Product\n"
                    + "WHERE category_id = ?\n"
                    + "AND status = 1";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            List<Product> listD = new ArrayList<>();
            while (rs.next()) {
                Product a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                listD.add(a);
            }
            return listD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> searchByName(String txtSearch) {
        try {
            String query = "SELECT * FROM Product\n"
                    + "WHERE product_name LIKE ?\n"
                    + "AND status = 1";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            List<Product> listD = new ArrayList<>();
            while (rs.next()) {
                Product a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                listD.add(a);
            }
            return listD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getRandomProduct() {
        try {
            String query = "SELECT TOP 4 id, product_name, title, price, img, description, category_id, seller_id, quantity, status\n"
                    + "FROM Product\n"
                    + "WHERE status = 1\n"
                    + "GROUP BY id, product_name, title, price, img, description, category_id, seller_id, quantity, status\n"
                    + "ORDER BY NEWID();";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductByPrice(int minPrice, int maxPrice) {
        List<Product> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM Product\n"
                    + "WHERE price BETWEEN ? AND ?\n"
                    + "AND status = 1";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, minPrice);
            ps.setInt(2, maxPrice);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "erro feching product", e);
        }
        return list;
    }

    public Account getLogin(String username, String password) {
        try {
            String query = "SELECT * FROM [User]\n"
                    + "WHERE username = ?\n"
                    + "AND password = ?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account checkAccExist(String username) {
        try {
            String query = "SELECT * FROM [User]\n"
                    + "WHERE username = ?\n";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getRegister(String user, String pass) {
        String query = "INSERT INTO [User]\n"
                + "VALUES(?, ?, 1, 3);";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductBySellID(int id) {
        try {
            String query = "SELECT * FROM Product\n"
                    + "WHERE seller_id = ? \n"
                    + "AND status = 1;";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            List<Product> listD = new ArrayList<>();
            while (rs.next()) {
                Product a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                listD.add(a);
            }
            return listD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteProduct(String id) {
        String query = "Update Product\n"
                + "Set status = 0\n"
                + "WHERE id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(String name, String title, String price,
            String image, String description, String category, int sellID) {
        String query = "INSERT INTO Product (product_name, title, price, img, description, category_id, seller_id, quantity, status)\n"
                + "VALUES \n"
                + "(?,?,?,?,?,?,?,10,1);";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, title);
            ps.setString(3, price);
            ps.setString(4, image);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sellID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(String name, String title, String price,
            String image, String description, String category, String pid) {
        String query = "Update Product\n"
                + "SET product_name = ?,\n"
                + "title = ?,\n"
                + "price = ?,\n"
                + "img = ?,\n"
                + "[description] = ?,\n"
                + "category_id = ?\n"
                + "WHERE id = ?;";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, title);
            ps.setString(3, price);
            ps.setString(4, image);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getImageByPrd(String id) {
        List<String> img = new ArrayList<>();
        String query = "SELECT image_url FROM Gallery\n"
                + "WHERE product_id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                img.add(rs.getString("image_url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    public void insertOrder(Account a, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            // add order
            String query = "INSERT INTO Orders \n"
                    + "VALUES (?, ?, ?, ?, ?)";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getUsername());
            ps.setString(3, date);
            ps.setInt(4, 1);
            ps.setDouble(5, cart.getTotalMoney());
            ps.executeUpdate();
            // lay order_id vua insert
            String sql1 =   "SELECT TOP 1 id FROM Orders ORDER BY id desc";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();
            // add vao bang Order_Detail
            if (rs.next()) {
                int oId = rs.getInt("id");
                for(Item i : cart.getListItems()) {
                    String sql2 = "INSERT INTO Order_Details"
                            + "VALUES(?, ?, ?, ?)";
                    conn = new DBConnect().getConnection();
                    ps = conn.prepareStatement(sql2);
                    ps.setInt(1, oId);
                    ps.setInt(2, i.getProduct().getId());
                    ps.setDouble(3, i.getPrice());
                    ps.setInt(4, i.getQuantity());
                    ps.executeUpdate();
                }
            }
            // cap nhat lai so luong san pham
            String sql3 = "UPDATE Product"
                    + "SET quantity = quantity - ?"
                    + "WHERE id = ?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql3);
            for (Item i : cart.getListItems()) {
                ps.setInt(1, i.getQuantity());
                ps.setInt(2, i.getProduct().getId());
                ps.executeUpdate();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
