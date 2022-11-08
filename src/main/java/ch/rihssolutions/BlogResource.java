package ch.rihssolutions;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/blog")
public class BlogResource {

    @Inject
    BlogService blogService;

    @GET
    public List<Blog> hello() {
        return Blog.listAll();
    }

    @Transactional
    @POST
    public void addBlog(Blog blog) {
        blog.persist();
    }
    
}
