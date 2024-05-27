/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;

/**
 *
 * @author TDG
 */
public class Cart {
    private int cart_id;
    private int user_id;
    private String promotion_id;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Cart() {
    }

    public Cart(int cart_id, int user_id, String promotion_id, Timestamp created_at, Timestamp updated_at) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.promotion_id = promotion_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(String promotion_id) {
        this.promotion_id = promotion_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Cart{" + "cart_id=" + cart_id + ", user_id=" + user_id + ", promotion_id=" + promotion_id + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
    
}
