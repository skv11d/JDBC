package org.example;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.example.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorHelper {

    private SessionFactory factory;

    public AuthorHelper() {
        factory = HibernateUtil.getFactory();
    }

    public List<Author> getAuthorList() {

        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);

        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();

        return authorList;
    }

    public Author getAuthorById(long id) {

        Session session = factory.openSession();
        Author author = session.get(Author.class, id);

        return author;
    }

    public Author addAuthor(Author author) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.save(author);

        session.getTransaction().commit();

        session.close();

        return author;
    }
}
