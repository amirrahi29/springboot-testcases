package com.crud.example.demo_crud.response;

public class BlogRequest {
    private int id;
    private String title;
    private String image;
    private String date;

    // **Default Constructor**
    public BlogRequest() {}

    // **Constructor with all fields**
    public BlogRequest(int id, String title, String image, String date) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.date = date;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
