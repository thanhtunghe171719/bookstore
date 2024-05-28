/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author TDG
 */
public class Product {
    private int bookId;
    private String title;
    private String author;
    private String image;
    private int categoryId;
    private String publishingHouse;
    private int publishedYear;
    private String size;
    private String weight;
    private String summary;
    private BigDecimal price;
    private Integer rating;
    private Integer discount;
    private int stock;
    private Timestamp createAt;
    private Timestamp updatedAt;

    public Product() {
    }

    public Product(int bookId, String title, String author, String image, int categoryId, String publishingHouse, int publishedYear, String size, String weight, String summary, BigDecimal price, Integer rating, Integer discount, int stock, Timestamp createAt, Timestamp updatedAt) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.image = image;
        this.categoryId = categoryId;
        this.publishingHouse = publishingHouse;
        this.publishedYear = publishedYear;
        this.size = size;
        this.weight = weight;
        this.summary = summary;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
        this.stock = stock;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" + "bookId=" + bookId + ", title=" + title + ", author=" + author + ", image=" + image + ", categoryId=" + categoryId + ", publishingHouse=" + publishingHouse + ", publishedYear=" + publishedYear + ", size=" + size + ", weight=" + weight + ", summary=" + summary + ", price=" + price + ", rating=" + rating + ", discount=" + discount + ", stock=" + stock + ", createAt=" + createAt + ", updatedAt=" + updatedAt + '}';
    }
    
}
