package ch.rihssolutions;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Blog extends PanacheEntity {

    // @JsonbProperty("neuer-title")
    public String title;
    public String content;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog [title=" + title + ", content=" + content + "]";
    }
}
