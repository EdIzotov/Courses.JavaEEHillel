package com.model;

import java.util.Objects;

public class Document {
    private String name;
    private User author;

    public Document(String name, User author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(name, document.name) &&
                Objects.equals(author, document.author);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }
}
