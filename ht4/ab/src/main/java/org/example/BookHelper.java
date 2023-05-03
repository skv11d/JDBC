package org.example;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookHelper {

    private SessionFactory factory;

    public BookHelper() {
        factory = HibernateUtil.getFactory();
    }

    public List<Book> getBookList() {

        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();

        return bookList;
    }

    public Book getBookById(long id) {

        Session session = factory.openSession();
        Book book = session.get(Book.class, id);

        return book;
    }

    public Book addBook(Book book) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();

        session.close();

        return book;
    }
}
