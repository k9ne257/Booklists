package com.example.bookslists.models;

public class Volume {
    private String authoren, publisher, publishDate, title, link, isbn, imageURL, price;

    public Volume(String authoren, String publisher, String publishDate, String title, String link, String isbn, String imageURL, String price) {
        this.authoren = authoren;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.title = title;
        this.link = link;
        this.isbn = isbn;
        this.imageURL = imageURL;
        this.price = price;
    }

    public String getAuthoren() {
        return authoren;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPrice() {
        return price;
    }


    public String getImageURL() {
        return imageURL;
    }
}
