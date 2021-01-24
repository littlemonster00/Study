package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    BlogMockedData blogMockedData = BlogMockedData.getInstance();

    @RequestMapping("/")
    public String index2() {
        return "Hello again";
    }

    @PostMapping("/")
    public String index() {
        return "You are post method";
    }

    @GetMapping("/blogs")
    public List<Blog> blogs() {
        return blogMockedData.fetchBlogs();
    }

    // Get blog by id
    @GetMapping("/blog/{id}")
    public Blog getBlogById(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogMockedData.getBlogById(blogId);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return blogMockedData.createBlog(id, title, content);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return blogMockedData.updateBlog(blogId, title, content);
    }

}