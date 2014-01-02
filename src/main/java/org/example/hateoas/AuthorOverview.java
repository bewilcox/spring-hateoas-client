package org.example.hateoas;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bewilcox
 * Date: 02/01/14
 */
public class AuthorOverview extends ResourceSupport {

    private String authorFormattedName;
    private List<String> booksTitles;

    public AuthorOverview() {
        this.booksTitles = new ArrayList<>();
    }

    public String getAuthorFormattedName() {
        return authorFormattedName;
    }

    public void setAuthorFormattedName(String authorFormattedName) {
        this.authorFormattedName = authorFormattedName;
    }

    public List<String> getBooksTitles() {
        return booksTitles;
    }

    public void setBooksTitles(List<String> booksTitles) {
        this.booksTitles = booksTitles;
    }
}
