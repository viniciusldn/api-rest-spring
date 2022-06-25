package com.trybe.spring.application;

import com.trybe.spring.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class BookController.
 */
@Controller
@Path("/api/books")
public class BookController {

  /** The books. */
  protected List<Book> books = new ArrayList<>();

  /**
   * Adds the.
   *
   * @param book the book
   * @return the response
   */
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response add(Book book) {
    books.add(book);
    return Response.ok(book).build();
  }

  /**
   * Returns all books.
   *
   * @param name the name
   * @return the response
   */
  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public Response findAll(@QueryParam("filter") String name) {
    List<Book> booksList = this.books;
    if (name != null) {
      booksList = books.stream().filter(b -> b.getName().equals(name)).collect(Collectors.toList());
    }
    return Response.ok(booksList).build();
  }

  /**
   * Returns book by id.
   *
   * @param id the id
   * @return the response
   */
  @GET
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response findById(@PathParam("id") UUID id) {
    try {
      Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();
      return Response.ok(book).build();
    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }

  /**
   * Updates a book.
   *
   * @param id the id
   * @param newBook the new book
   * @return the response
   */
  @PUT
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response update(@PathParam("id") UUID id, Book newBook) {
    try {
      Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();

      books.set(books.indexOf(book), newBook);

      return Response.ok(newBook).build();
    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }

  /**
   * Deletes book by id.
   *
   * @param id the id
   * @return the response
   */
  @DELETE
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response delete(@PathParam("id") UUID id) {
    try {
      Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElseThrow();

      books.remove(book);

      return Response.ok(book).build();
    } catch (NoSuchElementException e) {
      return Response.status(404).build();
    }
  }
}