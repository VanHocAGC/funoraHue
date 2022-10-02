package com.example.funovahue.repo;

import com.example.funovahue.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog,Long> {

}
