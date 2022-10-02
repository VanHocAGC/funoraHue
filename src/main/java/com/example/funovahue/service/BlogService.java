package com.example.funovahue.service;

import com.example.funovahue.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlog();
    Blog getBlog(Long id);
    Blog saveblog(Blog blog);


}
