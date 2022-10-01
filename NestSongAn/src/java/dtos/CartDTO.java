/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.TreeMap;

/**
 *
 * @author Admin
 */
public class CartDTO {
    private TreeMap<ProductDTO, Integer> list;
    private long cartID;

    public CartDTO() {
        list = new TreeMap<>();
        cartID = System.currentTimeMillis();
    }

    public CartDTO(TreeMap<ProductDTO, Integer> list, long cartID) {
        this.list = list;
        this.cartID = cartID;
    }

    public TreeMap<ProductDTO, Integer> getList() {
        return list;
    }

    public void setList(TreeMap<ProductDTO, Integer> list) {
        this.list = list;
    }

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }
    
    public void addToCart(ProductDTO p, int quantity){
        boolean bln = list.containsKey(p);
        if(bln){
            int ql = list.get(p);
            quantity += ql;
            list.put(p, quantity);
        } else {
            list.put(p, quantity);
        }
    }
    
    public void subToCart(ProductDTO p , int quantity){
        boolean bln = list.containsKey(p);
        if(bln){
            int ql = list.get(p);
            quantity = ql - quantity;
            if(quantity <= 0){
                list.remove(p);
            } else {
                list.remove(p);
                list.put(p, quantity);
            }
            
        }
    }
    
    public void removeToCart(ProductDTO p){
        boolean bln = list.containsKey(p);
        if(bln){
            list.remove(p);
        }
    }
    
}
