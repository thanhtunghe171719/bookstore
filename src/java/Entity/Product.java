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
public class Product {
    private int book_id;
    private String picture;
    private String title;
    private String author;
    private int published_year;
    private String genre;
    private String summary;
    private int price;
    private int discount;
    private int stock;
    private Timestamp create_at;
    private Timestamp update_at;

    public Product() {
    }

    public Product(int book_id, String picture, String title, String author, int published_year, String genre, String summary, int price, int discount, int stock, Timestamp create_at, Timestamp update_at) {
        this.book_id = book_id;
        this.picture = picture;
        this.title = title;
        this.author = author;
        this.published_year = published_year;
        this.genre = genre;
        this.summary = summary;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        return "Product{" + "book_id=" + book_id + ", picture=" + picture + ", title=" + title + ", author=" + author + ", published_year=" + published_year + ", genre=" + genre + ", summary=" + summary + ", price=" + price + ", discount=" + discount + ", stock=" + stock + ", create_at=" + create_at + ", update_at=" + update_at + '}';
    }
    
    
}
