/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Duc Anh
 */
public class OrderDetail {
    
    private int id;
    private int orderId;
    private int pid;
    private double price;
    private int num;
    private String pname;
    private String usename;

    public OrderDetail() {
    }

    public OrderDetail(int id, int orderId, int pid, double price, int num, String pname, String usename) {
        this.id = id;
        this.orderId = orderId;
        this.pid = pid;
        this.price = price;
        this.num = num;
        this.pname = pname;
        this.usename = usename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "id=" + id + ", orderId=" + orderId + ", pid=" + pid + ", price=" + price + ", num=" + num + ", pname=" + pname + ", usename=" + usename + '}';
    }
    
}
