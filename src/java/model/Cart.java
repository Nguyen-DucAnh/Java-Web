/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Cart {

    private List<Item> listItems;

    public Cart() {
    }

    public Cart(List<Item> listItems) {
        this.listItems = listItems;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }
    
    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    private Item getItemById(int id) {
        for (Item i : listItems) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Item i) {
        if (getItemById(i.getProduct().getId()) != null) {
            Item m = getItemById(i.getProduct().getId());
            m.setQuantity(m.getQuantity() + i.getQuantity());
        } else {
            listItems.add(i);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            listItems.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : listItems) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    public Product getProductById(int id, List<Product> list) {
        for (Product i : list) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public Cart(String txt, List<Product> list) {
        listItems = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("/");
                for (String i : s) {
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    String size = n[1];
                    int quantity = Integer.parseInt(n[2]);
                    Product p = getProductById(id, list);
                    Item t = new Item(p, quantity, p.getPrice(), size);
                    addItem(t);
                }
            }
        } catch (Exception e) {
            
        }
    }
    
    public String listCartToString() {
        String str = "";
        for (Item i : listItems) {
            str += i.getProduct().getId() + ":" + i.getSize() + ":" + i.getQuantity() + "/";
        }
        return str;
    }
}
