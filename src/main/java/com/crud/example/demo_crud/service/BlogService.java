package com.crud.example.demo_crud.service;

import com.crud.example.demo_crud.model.BlogModel;
import com.crud.example.demo_crud.response.BasicResponseMsg;
import com.crud.example.demo_crud.response.BlogRequest;
import org.springframework.web.multipart.MultipartFile;

public interface BlogService {

    BasicResponseMsg addBlog(BlogModel blogModel, MultipartFile blogImage);

    BasicResponseMsg getBlogById(BlogRequest blogRequest);

    BasicResponseMsg getAllBlogs();

    BasicResponseMsg updateBlog(BlogModel blogModel, MultipartFile blogImage);

    BasicResponseMsg deleteBlogById(BlogRequest blogRequest);

    BasicResponseMsg getBlogByTitle(String title);
}
