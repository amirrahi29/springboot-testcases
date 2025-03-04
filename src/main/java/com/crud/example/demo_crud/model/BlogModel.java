package com.crud.example.demo_crud.model;

public class BlogModel {

    private int blogId;
    private String blogTitle;
    private String blogImage;

    // ✅ Default constructor (needed for frameworks like Jackson)
    public BlogModel() {}

    // ✅ Constructor with parameters
    public BlogModel(int blogId, String blogTitle, String blogImage) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogImage = blogImage;
    }

    // ✅ Getters and Setters
    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }
}
