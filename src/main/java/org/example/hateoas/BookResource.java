package org.example.hateoas;

import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

/**
 * User: bewilcox
 * Date: 31/12/13
 */
public class BookResource extends ResourceSupport {

    private String     isbn         ;
    private String     title        ;
    private BigDecimal price        ;
    private Integer    quantity     ;
    private Integer    discount     ;
    private Short      availability ;
    private Short      bestSeller   ;


    public BookResource() {

    }

    public BookResource(String isbn, String title, BigDecimal price, Integer quantity, Integer discount, Short availability, Short bestSeller) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.availability = availability;
        this.bestSeller = bestSeller;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Short getAvailability() {
        return availability;
    }

    public void setAvailability(Short availability) {
        this.availability = availability;
    }

    public Short getBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(Short bestSeller) {
        this.bestSeller = bestSeller;
    }
}
