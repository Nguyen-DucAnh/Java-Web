/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Đông
 */
public class Contact {
    private String name,email,sub,mes;
    private int id, cid;

    public Contact() {
    }

    public Contact(String name, String email, String sub, String mes, int id, int cid) {
        this.name = name;
        this.email = email;
        this.sub = sub;
        this.mes = mes;
        this.id = id;
        this.cid = cid;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", email=" + email + ", sub=" + sub + ", mes=" + mes + ", id=" + id + ", cid=" + cid + '}';
    }
    
    
    
    
}
