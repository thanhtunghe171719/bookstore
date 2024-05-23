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
public class users {
    private int user_id;
    private String username;
    private String password;
    private String email;
    private String role;
    private Timestamp create_at;
    private Timestamp update_at;

    public users() {
    }

    public users(int user_id, String username, String password, String email, String role, Timestamp create_at, Timestamp update_at) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "users{" + "user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email + ", role=" + role + ", create_at=" + create_at + ", update_at=" + update_at + '}';
    }
    
}
