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
public class Campaigns {
    private int compaign_id;
    private int user_id;
    private int book_id;
    private String name;
    private String image;
    private String description;
    private String summary;
    private Date start_date;
    private Date end_date;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Campaigns() {
    }

    public Campaigns(int compaigh_id, int user_id, int book_id, String name, String image, String description, String summary, Date start_date, Date end_date, Timestamp created_at, Timestamp updated_at) {
        this.compaign_id = compaigh_id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.summary = summary;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getCompaigh_id() {
        return compaign_id;
    }

    public void setCompaigh_id(int compaigh_id) {
        this.compaign_id = compaigh_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
        return "Campaigns{" + "compaign_id=" + compaign_id + ", user_id=" + user_id + ", book_id=" + book_id + ", name=" + name + ", image=" + image + ", description=" + description + ", summary=" + summary + ", start_date=" + start_date + ", end_date=" + end_date + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

}