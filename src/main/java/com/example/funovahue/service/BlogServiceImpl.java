package com.example.funovahue.service;

import com.example.funovahue.entity.Blog;
import com.example.funovahue.repo.BlogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor @Slf4j
public class BlogServiceImpl implements BlogService{
    private final BlogRepo blogRepo;
    @Override
    public List<Blog> getAllBlog() {
        return null;
    }

    @Override
    public Blog getBlog(Long id) {
        return null;
    }

    @Override
    public Blog saveblog(Blog blog) {
        return null;
    }
}
