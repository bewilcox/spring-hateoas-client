package org.example.hateoas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * User: bewilcox
 * Date: 31/12/13
 */
@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
    private static final String BASE_URL = "http://localhost:8989/";
    private static final String BOOKS_REL_NAME = "listOfBook";
    private static final String SELF = "self";

    @RequestMapping(value = "/overview/{authorId}")
    @ResponseBody
    public HttpEntity<AuthorOverview> overview(@PathVariable String authorId) {

        RestTemplate restTemplate = new RestTemplate();
        AuthorResource authorResource =  restTemplate.getForObject(BASE_URL+"authors/"+ authorId, AuthorResource.class);

        LOG.debug("AuthorResource : {} link(s) found.",authorResource.getLinks().size());
        for (Link link : authorResource.getLinks()) {
            LOG.debug("Link info : rel = {}, href = {}", link.getRel(), link.getHref());
        }

        Link booksLink = authorResource.getLink(BOOKS_REL_NAME);
        BookResources booksResources = restTemplate.getForObject(booksLink.getHref(), BookResources.class);

        AuthorOverview authorOverview = new AuthorOverview();
        authorOverview.setAuthorFormattedName(authorResource.getFirstName() + " " + authorResource.getLastName());

        for (BookResource bookResource: booksResources) {
            authorOverview.getBooksTitles().add(bookResource.getTitle());
        }

        authorOverview.add(linkTo(methodOn(MainController.class).overview(authorId)).withSelfRel());
        authorOverview.add(new Link(authorResource.getLink(SELF).getHref(), "author"));

        return new ResponseEntity<>(authorOverview, HttpStatus.OK);
    }

}
