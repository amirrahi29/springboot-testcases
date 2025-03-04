package com.crud.example.demo_crud.ServiceImpl;

import com.crud.example.demo_crud.dao.BlogDao;
import com.crud.example.demo_crud.model.BlogModel;
import com.crud.example.demo_crud.response.BasicResponseMsg;
import com.crud.example.demo_crud.serviceImpl.BlogServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Enables Mockito Annotations
class BlogServiceImplTest {

    @InjectMocks
    private BlogServiceImpl blogServiceImpl;  // Inject mocks into service

    @Mock
    private BlogDao blogDao;  // Mock DAO layer

    @Test
    void getBlogByTitleTest() {
        // Mock behavior
        BlogModel mockBlog = new BlogModel();
        mockBlog.setBlogTitle("title1");
        when(blogDao.findByBlogTitle("title1")).thenReturn(Optional.of(mockBlog));

        // Call the actual method
        BasicResponseMsg blogResponse = blogServiceImpl.getBlogByTitle("title1");

        // Assertions
        Assertions.assertNotNull(blogResponse);
        Assertions.assertEquals(200, blogResponse.getStatus());
        Assertions.assertEquals("Blog found", blogResponse.getMessage());
        Assertions.assertEquals("title1", ((BlogModel) blogResponse.getData()).getBlogTitle());

        // Verify that findByBlogTitle was called once
        verify(blogDao, times(1)).findByBlogTitle("title1");
    }
}
