package ch.rihssolutions;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/blog")
public class BlogResource {

    @Inject
    BlogService blogService;

    @GET
    public List<Blog> hello() {
        return blogService.getBlogs();
    }
    
}
