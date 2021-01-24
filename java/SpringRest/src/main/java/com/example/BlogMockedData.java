package com.example;

import java.util.ArrayList;
import java.util.List;

public class BlogMockedData {
    // list of blog posts
    private List<Blog> blogs;

    private static BlogMockedData instance = null;

    // singleton parttern
    public static BlogMockedData getInstance() {
        if (instance == null) {
            return new BlogMockedData();
        }
        return instance;
    }

    // Contructor
    public BlogMockedData() {
        blogs = new ArrayList<Blog>();
        blogs.add(new Blog(1, "title 1", "content 1"));
    }

    // return all blogs
    public List<Blog> fetchBlogs() {
        return blogs;
    }

    // create blog
    public Blog createBlog(int id, String title, String content) {
        Blog newBlog = new Blog(id, title, content);
        blogs.add(newBlog);
        return newBlog;
    }

    // get blog by id
    public Blog getBlogById(int id) {
        for (Blog b : blogs) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public Blog updateBlog(int id, String title, String content) {
        for (Blog b : blogs) {
            if (b.getId() == id) {
                int blogIndex = blogs.indexOf(b);
                b.setTitle(title);
                b.setContent(content);
                blogs.set(blogIndex, b);
                return b;
            }
        }
        return null;
    }

}