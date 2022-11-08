package ch.rihssolutions;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import io.quarkus.logging.Log;

import org.eclipse.microprofile.openapi.annotations.media.Content;

@Path("/blog")
public class BlogResource {

    public record BlogOverviewDto(String title) {
        public BlogOverviewDto(Blog blog) {
            this(blog.title);
        }
    }

    @GET
    public List<BlogOverviewDto> list() {
        Blog.listAll().forEach(b -> Log.infof("Blog: %s", b));
        return Blog.streamAll().map(b -> new BlogOverviewDto((Blog) b)).toList();
    }

    @Transactional
    @POST
    @Operation(description = "Add new Blog-Post.")
    @RequestBody(content = @Content(mediaType = "application/json", example = "{ \"title\": \"title\", \"content\": \"content\" }"))
    public void addBlog(Blog blog) {
        Log.infof("Blog: %s", blog.title);
        blog.persist();
    }
    
}
