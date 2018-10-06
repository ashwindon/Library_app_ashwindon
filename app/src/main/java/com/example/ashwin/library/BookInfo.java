package com.example.ashwin.library;

public class BookInfo {
    public String title, author, image, genre, subgenre, publisher;
    public String qty;

    public BookInfo(String title, String author, String image, String genre, String subgenre, String publisher, String qty) {
        this.title = title;
        this.author = author;
        this.image = image;
        this.genre = genre;
        this.subgenre = subgenre;
        this.publisher = publisher;
        this.qty = qty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
