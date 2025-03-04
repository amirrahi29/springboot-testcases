package com.crud.example.demo_crud.controller;

import com.crud.example.demo_crud.model.BlogModel;
import com.crud.example.demo_crud.response.BasicResponseMsg;
import com.crud.example.demo_crud.response.BlogRequest;
import com.crud.example.demo_crud.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final BlogService blogService;
    private final ObjectMapper objectMapper; // Make this final

    // Constructor Injection for both dependencies
    public BlogController(BlogService blogService, ObjectMapper objectMapper) {
        this.blogService = blogService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("addBlog")
    public ResponseEntity<BasicResponseMsg> addBlog(
        @RequestParam("blog_image") MultipartFile blogImage,
        @RequestParam("blog_data") String blogData
        ){
        BasicResponseMsg responseMsg = new BasicResponseMsg();
        BlogModel blogModel = null;
        try {
            blogModel = objectMapper.readValue(blogData, BlogModel.class);
            responseMsg = blogService.addBlog(blogModel,blogImage); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
       return new ResponseEntity<>(responseMsg,HttpStatus.OK);
    }

    @GetMapping("getBlogById")
    public ResponseEntity<BasicResponseMsg> getBlogById(@RequestBody BlogRequest blogRequest){
         BasicResponseMsg responseMsg = new BasicResponseMsg();
         try {
            responseMsg = blogService.getBlogById(blogRequest);     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(responseMsg,HttpStatus.OK);
    }

    @GetMapping("getAllBlogs")
    public ResponseEntity<BasicResponseMsg> getAllBlogs(){
         BasicResponseMsg responseMsg = new BasicResponseMsg();
         try {
            responseMsg = blogService.getAllBlogs();     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(responseMsg,HttpStatus.OK);
    }

    @PostMapping("updateBlog")
    public ResponseEntity<BasicResponseMsg> updateBlog(
        @RequestParam("blog_image") MultipartFile blogImage,
        @RequestParam("blog_data") String blogData
        ){
        BasicResponseMsg responseMsg = new BasicResponseMsg();
        BlogModel blogModel = null;
        try {
            blogModel = objectMapper.readValue(blogData, BlogModel.class);
            responseMsg = blogService.updateBlog(blogModel,blogImage); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
       return new ResponseEntity<>(responseMsg,HttpStatus.OK);
    }

    @PostMapping("deleteBlogById")
    public ResponseEntity<BasicResponseMsg> deleteBlogById(@RequestBody BlogRequest blogRequest){
        BasicResponseMsg responseMsg = new BasicResponseMsg();
        try {
            responseMsg = blogService.deleteBlogById(blogRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

    @GetMapping("getBlog/{title}")
    public ResponseEntity<BasicResponseMsg> getBlogByTitle(@PathVariable String title) {
        BasicResponseMsg responseMsg = new BasicResponseMsg();
        try {
            responseMsg = blogService.getBlogByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

}
