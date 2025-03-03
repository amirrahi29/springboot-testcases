package com.crud.example.demo_crud.Service;

import com.crud.example.demo_crud.dao.BlogDao;
import com.crud.example.demo_crud.model.BlogModel;
import com.crud.example.demo_crud.response.BasicResponseMsg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BlogServiceTest {

    @Autowired
    private BlogDao blogDao;

    @Test
    public void getBlockCheckTest() {

        String title = "title1";
        Optional<BlogModel> blog = blogDao.findByBlogTitle(title);

        //check is present
        assertTrue(blog.isPresent());
    }

    @Test
    public void getBlogByTitleTest() {

        String title = "title1";
        Optional<BlogModel> blog = blogDao.findByBlogTitle(title);
        //data check
        BlogModel blogData = blog.get();
        //assertEquals(title, blogData.getBlogTitle(), "Blog title should match");
        Assertions.assertEquals(title, blogData.getBlogTitle(), "Blog title should match");

    }

    @Test
    public void getAllBlogsTest() {
        List<BlogModel> allBlogs = blogDao.findAll();
        File savFileDirectory = null;
        try {
            savFileDirectory = new ClassPathResource("static/blogImages").getFile();
            for (BlogModel blog : allBlogs) {
                blog.setBlogImage(savFileDirectory + File.separator + blog.getBlogImage());
            }
            Assertions.assertNotNull(allBlogs);
          //  assertNotNull(allBlogs);
           // Assertions.assertNull(allBlogs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
