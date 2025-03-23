/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Main {

    public static void main(String[] args) {
        DAO dao = new DAO();
        int id = 4;

        List<Product> list = dao.getProductBySellID(id);
        System.out.println(list.toString());
    }

}
