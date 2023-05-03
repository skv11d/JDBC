package org.example;

import org.example.entity.Author;
import org.example.entity.Book;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author();

        author1.setName("AAA");

        AuthorHelper authorHelper = new AuthorHelper();
        authorHelper.addAuthor(author1);

        Book book1 = new Book();

        book1.setName("Yea");
        book1.setAuthorId(1);

        BookHelper bookHelper = new BookHelper();
        bookHelper.addBook(book1);
    }
}