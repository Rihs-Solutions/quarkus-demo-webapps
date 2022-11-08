package ch.rihssolutions;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.media.Content;

@Path("/blog")
public class BlogResource {

    // @Inject
    // BlogDummyService blogService;

    @GET
    public List<Blog> list() {
        return Blog.listAll();
    }

    @Transactional
    @POST
    @Operation(description = "Add new Blog-Post.")
    @RequestBody(content = @Content(mediaType = "application/json", example = "{ \"title\": \"title\", \"content\": \"content\" }"))
    public void addBlog(Blog blog) {
        blog.persist();
    }
    
}
