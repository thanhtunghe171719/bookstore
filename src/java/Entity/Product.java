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
    private String title;
    private String author;
    private String image;    
    private int category_id;
    private int published_year;
    private String size;
    private String weight;
    private String summary;
    private int price;
    private int discount;
    private int stock;
    private Timestamp create_at;
    private Timestamp update_at;

    public Product() {
    }

    public Product(int book_id, String title, String author, String image, int category_id, int published_year, String size, String weight, String summary, int price, int discount, int stock, Timestamp create_at, Timestamp update_at) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.category_id = category_id;
        this.published_year = published_year;
        this.size = size;
        this.weight = weight;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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
        return "Product{" + "book_id=" + book_id + ", title=" + title + ", author=" + author + ", image=" + image + ", category_id=" + category_id + ", published_year=" + published_year + ", size=" + size + ", weight=" + weight + ", summary=" + summary + ", price=" + price + ", discount=" + discount + ", stock=" + stock + ", create_at=" + create_at + ", update_at=" + update_at + '}';
    }

}
