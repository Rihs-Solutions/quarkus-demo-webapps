package ch.rihssolutions;

import java.util.List;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BlogDummyService {

    public List<Blog> getBlogs() {
        return List.of(new Blog("Hello from RESTEasy Reactive", "This is a blog post"));
    }
}
