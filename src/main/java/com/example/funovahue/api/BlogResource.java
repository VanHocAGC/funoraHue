package com.example.funovahue.api;

import com.example.funovahue.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BlogResource {
    private final BlogService blogservice;
    
}
