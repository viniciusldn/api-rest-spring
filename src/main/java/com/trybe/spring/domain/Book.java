package com.trybe.spring.domain;

import java.util.Objects;
import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * The Class Book.
 */
public class Book {

  /** The id. */
  private UUID id;

  /** The name. */
  private String name;

  /** The author. */
  private String author;

  /** The get id. */
  public Object getId;

  /**
   * Instantiates a new book.
   */
  public Book() {
    this.id = UUID.randomUUID();
  }

  /**
   * Instantiates a new book.
   *
   * @param name the name
   * @param author the author
   */
  public Book(String name, String author) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.author = author;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the author.
   *
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Sets the author.
   *
   * @param author the new author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Book other = (Book) obj;
    return Objects.equals(author, other.author) && Objects.equals(id, other.id)
        && Objects.equals(name, other.name);
  }
}