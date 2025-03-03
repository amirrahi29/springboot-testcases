package com.crud.example.demo_crud.dao;

import com.crud.example.demo_crud.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<BlogModel,Integer> {
    
}
