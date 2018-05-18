package com.example.demo.entity;

import javafx.beans.DefaultProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "Can nhap ten")
    @Size(min = 8, message = "it nhat 8 ky tu")
    private String name;
    private String category;
    private String description;
    @NotNull(message = "Null roi")
    private String imgUrl;
    @Min(1)
    private int price;
    private int status;
    private String timeCreatedAt;
    private String timeEditAt;

    public Food() {
    }

    public Food(@NotNull(message = "Can nhap ten") @Size(min = 8, message = "it nhat 8 ky tu") String name, String category, String description, @NotNull(message = "Null roi") String imgUrl, @Min(1) int price, String timeCreatedAt, String timeEditAt) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.timeCreatedAt = timeCreatedAt;
        this.timeEditAt = timeEditAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTimeCreatedAt() {
        return timeCreatedAt;
    }

    public void setTimeCreatedAt(String timeCreatedAt) {
        this.timeCreatedAt = timeCreatedAt;
    }

    public String getTimeEditAt() {
        return timeEditAt;
    }

    public void setTimeEditAt(String timeEditAt) {
        this.timeEditAt = timeEditAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
