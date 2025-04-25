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
import model.Contact;
import model.Item;
import model.Order;
import model.OrderDetail;
import model.OrderStatus;
import model.User;

/**
 *
 * @author Nguyen Duc Anh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    OrderDAO odao = new OrderDAO();

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
            String query = "SELECT * FROM Account\n"
                    + "WHERE username = ? AND password = ? \n"
                    + "AND status = 1";
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
            String query = "SELECT * FROM Account\n"
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
        String query = "INSERT INTO Account\n"
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

    public List<User> getAllUser() {
        List<User> listU = new ArrayList<>();
        try {
            String query = "SELECT * FROM Account";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                User u = new User(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5));
                listU.add(u);
            }
            return listU;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int id) {
        try {
            String query = "SELECT * FROM [user]\n"
                    + "WHERE account_id = ?";

            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> listA = new ArrayList<>();
        try {
            String query = "SELECT * FROM Account";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                Account a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                if (rs.getInt(5) != 1) {
                    listA.add(a);
                }
            }
            return listA;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void unDeleteAccount(String id) {
        try {
            String query = "UPDATE Account SET status= 1\n"
                    + "where id =?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(String id) {
        try {
            String query = "UPDATE Account SET status= 0\n"
                    + "where id =?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account getAccountById(String id) {
        try {
            String query = "SELECT * FROM Account\n"
                    + "WHERE id =?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(int id, String fname, String lname,
            String emailD, String phoneD) {
        String query = "INSERT INTO [user]\n"
                + "VALUES(?,?,?,?,?);";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, emailD);
            ps.setString(5, phoneD);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String fname, String lname,
            String emailD, String phoneD, int id) {
        String query = "Update [user]\n"
                + "set first_name = ?,\n"
                + "last_name=?,\n"
                + "email=?,\n"
                + "phone=?\n"
                + "WHERE account_id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, emailD);
            ps.setString(4, phoneD);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(String password, int id) {
        String query = "Update  Account\n"
                + "SET password = ?\n"
                + "WHERE id = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassword(int id, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM Account WHERE id = ?"
                + " AND password = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    isValid = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
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
            String sql1 = "SELECT TOP 1 id FROM Orders ORDER BY id desc";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();
            // add vao bang Order_Detail
            if (rs.next()) {
                int oId = rs.getInt("id");
                for (Item i : cart.getListItems()) {
                    String sql2 = "INSERT INTO Order_Details "
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
            String sql3 = "UPDATE Product "
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

    public List<Order> getListOrder() {
        try {
            String query = "SELECT * FROM Orders";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                int oId = rs.getInt(5);
                Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), odao.getOrderStatusById(rs.getInt(5)), rs.getDouble(6));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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

    public List<Order> getOrderByStId(int id) {
        try {
            String query = "SELECT * FROM Orders\n"
                    + "WHERE status_id = ?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                int oId = rs.getInt(5);

                Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), odao.getOrderStatusById(rs.getInt(5)), rs.getDouble(6));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateOrderStatus(String sid, String id) {
        try {
            String query = "Update Orders\n"
                    + "SET status_id = ?\n"
                    + "WHERE id = ?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sid);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrderByUseId(int id) {
        try {
            String query = "SELECT * FROM Orders\n"
                    + "WHERE user_id = ?\n"
                    + "ORDER BY id desc";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                int oId = rs.getInt(5);
                Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), odao.getOrderStatusById(rs.getInt(5)), rs.getDouble(6));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order getOrderById(String id) {
        try {
            String query = "SELECT * FROM Orders\n"
                    + "WHERE id = ?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int oId = rs.getInt(5);
                Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), odao.getOrderStatusById(rs.getInt(5)), rs.getDouble(6));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteOrderByID(String id) {
        try {
            String query = "DELETE FROM Orders WHERE id = ?";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Contact> getAllContact() {
        List<Contact> listCt = new ArrayList<>();
        try {
            String query = "SELECT * FROM Contact";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact c = new Contact(rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(1),
                        rs.getInt(2));
                listCt.add(c);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCt;
    }

    public void insertConact(int id, String name, String email, String sub, String mes) {
        String query = "INSERT INTO Contact\n"
                + "VALUES(?,?,?,?,?);";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, sub);
            ps.setString(5, mes);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OrderStatus> getListOrStatus() {
        try {
            String query = "SELECT * FROM Order_Status";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<OrderStatus> list = new ArrayList<>();
            while (rs.next()) {
                OrderStatus o = new OrderStatus(rs.getInt(1), rs.getString(2));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<OrderDetail> getOrderDetail(String oid) {
        try {
            String query = "SELECT od.id AS order_detail_id, \n"
                    + "       od.order_id, \n"
                    + "       od.product_id,  \n"
                    + "       od.price, \n"
                    + "       od.num,\n"
                    + "	   p.product_name,\n"
                    + "       a.username\n"
                    + "FROM Order_Details od\n"
                    + "JOIN Product p ON od.product_id = p.id\n"
                    + "JOIN Orders o ON od.order_id = o.id\n"
                    + "JOIN Account a ON o.user_id = a.id\n"
                    + "WHERE od.order_id = ?;";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, oid);
            rs = ps.executeQuery();
            List<OrderDetail> list = new ArrayList<>();
            while (rs.next()) {
                OrderDetail o = new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTotalProduct() {
        String query = "SELECT COUNT(*) FROM Product";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<Product> pagingProduct(int index) {
        try {
            String query = "SELECT * FROM Product\n"
                    + "ORDER BY id\n"
                    + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1) * 6);
            rs = ps.executeQuery();
            List<Product> list = new ArrayList<>();
            while(rs.next()) {
                Product a = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getResponse(String message) {
        String response = "Tôi chưa biết câu này. Bạn có thể dạy tôi không?";
        try {
            ps = conn.prepareStatement("SELECT answer FROM Chat WHERE question = ?");
            ps.setString(1, message);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                response = rs.getString("answer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public boolean addNewResponse(String question, String answer) {
        try {
            ps = conn.prepareStatement("INSERT INTO Chat (question, answer) VALUES (?, ?)");
            ps.setString(1, question);
            ps.setString(2, answer);
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
