package com.trybe.spring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Book {
  private List<Book> books = new ArrayList<>();

  private UUID id;

  private String name;

  private String author;

  public Book(String name, String author) {
      this.id = UUID.randomUUID();
      this.name = name;
      this.author = author;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}

