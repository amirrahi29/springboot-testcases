package com.crud.example.demo_crud.ControllerTestCases;

import com.crud.example.demo_crud.controller.BlogController;
import com.crud.example.demo_crud.model.BlogModel;
import com.crud.example.demo_crud.response.BasicResponseMsg;
import com.crud.example.demo_crud.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BlogService blogService;

    @InjectMocks
    private BlogController blogController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
    }

    @Test
    void addBlog() throws Exception {
        // ✅ Mock Multipart File
        MockMultipartFile mockImage = new MockMultipartFile(
                "blog_image", "test.jpg", "image/jpeg", "image-content".getBytes());

        // ✅ Mock Blog Data JSON as String
        String blogData = "{\"blogTitle\": \"Test Blog\"}";

        // ✅ Mock Response
        BasicResponseMsg responseMsg = new BasicResponseMsg();
        responseMsg.setStatus(200);
        responseMsg.setMessage("Blog Added Successfully");

        when(blogService.addBlog(any(BlogModel.class), any(MultipartFile.class)))
                .thenReturn(responseMsg);

        // ✅ Perform the request with correct params
        mockMvc.perform(multipart("/api/addBlog")
                        .file(mockImage)  // Image File
                        .param("blog_data", blogData) // JSON as String
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Blog Added Successfully"));
    }


    @Test
    void getBlogById() throws Exception {
        BasicResponseMsg responseMsg = new BasicResponseMsg(200, "Blog Data found", null);

        when(blogService.getBlogById(any())).thenReturn(responseMsg);

        mockMvc.perform(get("/api/getBlogById")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new BlogModel(1, "Test Blog", "test.jpg"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Blog Data found"));
    }

    @Test
    void getAllBlogs() throws Exception {
        BasicResponseMsg responseMsg = new BasicResponseMsg(200, "All blogs", null);

        when(blogService.getAllBlogs()).thenReturn(responseMsg);

        mockMvc.perform(get("/api/getAllBlogs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("All blogs"));
    }

    @Test
    void updateBlog() throws Exception {
        MockMultipartFile mockImage = new MockMultipartFile(
                "blog_image", "updated.jpg", "image/jpeg", "updated-content".getBytes());

        // ✅ Use BlogModel instead of BlogRequest
        BlogModel blogModel = new BlogModel(1, "Updated Blog", "updated.jpg");
        String blogData = objectMapper.writeValueAsString(blogModel);

        MockMultipartFile mockBlogData = new MockMultipartFile(
                "blog_data", "", "application/json", blogData.getBytes());

        BasicResponseMsg responseMsg = new BasicResponseMsg(200, "Blog Updated", blogModel);

        when(blogService.updateBlog(any(BlogModel.class), any(MockMultipartFile.class)))
                .thenReturn(responseMsg);

        mockMvc.perform(multipart("/api/updateBlog")
                        .file(mockImage)
                        .file(mockBlogData) // ✅ Pass blog_data as a file
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Blog Updated"));
    }

    @Test
    void deleteBlogById() throws Exception {
        BasicResponseMsg responseMsg = new BasicResponseMsg(200, "Blog deleted", null);

        when(blogService.deleteBlogById(any())).thenReturn(responseMsg);

        mockMvc.perform(post("/api/deleteBlogById")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new BlogModel(1, "Test Blog", "test.jpg"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Blog deleted"));
    }

    @Test
    void getBlogByTitle() throws Exception {
        BasicResponseMsg responseMsg = new BasicResponseMsg(200, "Blog found", null);

        when(blogService.getBlogByTitle("title1")).thenReturn(responseMsg);

        mockMvc.perform(get("/api/getBlog/title1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Blog found"));
    }
}
