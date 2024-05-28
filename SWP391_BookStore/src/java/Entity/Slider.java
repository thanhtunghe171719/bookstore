/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author TDG
 */
public class Slider {
    private int sliderId;
    private int userId;
    private String title;
    private String image;
    private String status;

    public Slider() {
    }

    public Slider(int sliderId, int userId, String title, String image, String status) {
        this.sliderId = sliderId;
        this.userId = userId;
        this.title = title;
        this.image = image;
        this.status = status;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Slider{" + "sliderId=" + sliderId + ", userId=" + userId + ", title=" + title + ", image=" + image + ", status=" + status + '}';
    }
    
}