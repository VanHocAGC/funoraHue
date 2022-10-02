package com.example.funovahue.api;

import com.example.funovahue.entity.Blog;
import com.example.funovahue.service.BlogService;
import com.example.funovahue.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BlogResource {
    private final BlogService blogservice;

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogByID(@PathVariable Long id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/blog/{id}").toUriString());
        return ResponseEntity.created(uri).body(blogservice.getBlog(id));
    }

    @PostMapping("/blog/save")
    public ResponseEntity<?> saveBlog(Blog blog, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        blog.setPhotos(fileName);
        Blog saveblog = blogservice.saveblog(blog);
        String uploadDir = "blog-photos/" +saveblog.getId();
        FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/blog/save").toUriString());
        return ResponseEntity.created(uri).build();
    }
}
