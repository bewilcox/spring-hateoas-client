package org.example.hateoas;

import org.springframework.hateoas.ResourceSupport;

/**
 * User: bewilcox
 * Date: 31/12/13
 */
public class AuthorResource extends ResourceSupport{

    private String firstName;
    private String lastName;

    public AuthorResource() {

    }

    public AuthorResource(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
