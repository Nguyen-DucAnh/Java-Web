/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Duc Anh
 */
public class OrderStatus {
    
    private int id;
    private String sName;

    public OrderStatus() {
    }

    public OrderStatus(int id, String sName) {
        this.id = id;
        this.sName = sName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "OrderStatus{" + "id=" + id + ", sName=" + sName + '}';
    }
    
    
}
