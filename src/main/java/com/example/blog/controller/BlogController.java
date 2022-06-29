package com.example.blog.controller;

import com.example.blog.model.API;
import com.example.blog.model.Blog;
import com.example.blog.repository.BlogReposotyr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BlogController {
    private final BlogReposotyr blogReposotyr;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogs(){
        return ResponseEntity.status(200).body(blogReposotyr.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogByID(@PathVariable Integer id){
        return ResponseEntity.status(201).body(blogReposotyr.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<API> addBlog(@RequestBody Blog blog){
        blogReposotyr.save(blog);
        return ResponseEntity.status(201).body(new API("blog add !",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<API> deleteBlog(@PathVariable Integer id){
        blogReposotyr.deleteById(id);
        return ResponseEntity.status(201).body(new API("Blog deleted !",201));
    }
}
