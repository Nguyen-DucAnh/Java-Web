/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Order {
    
    private int id;
    private int uid;
    private String fullname;
    private String date;
    private OrderStatus statusID;
    private double totalmoney;

    public Order() {
    }

    public Order(int id, int uid, String fullname, String date, OrderStatus statusID, double totalmoney) {
        this.id = id;
        this.uid = uid;
        this.fullname = fullname;
        this.date = date;
        this.statusID = statusID;
        this.totalmoney = totalmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderStatus getStatusID() {
        return statusID;
    }

    public void setStatusID(OrderStatus statusID) {
        this.statusID = statusID;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", uid=" + uid + ", fullname=" + fullname + ", date=" + date + ", statusID=" + statusID + ", totalmoney=" + totalmoney + '}';
    }

    
}
