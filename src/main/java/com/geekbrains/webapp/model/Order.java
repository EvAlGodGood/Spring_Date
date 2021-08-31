package com.geekbrains.webapp.model;

public class Order {

    private Long id_order;
    private Long id;
    private String title;
    private String date;
    private int price;
    private String category;

    public Long getId_Order() {
        return id_order;
    }

    public void setId_Order(Long id) {
        this.id = id_order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Order() {
    }

    public Order(Long id_order, Long id, String title, String date, int price, String category) {
        this.id_order = id_order;
        this.id = id;
        this.title = title;
        this.date = date;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "\n Order{" +
                ", id_order=" + id_order +
                ", id=" + id +
                ", title=" + title +
                ", date=" + date +
                ", price=" + price +
                ", category=" + category +
                "}";
    }
}
