package org.example;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.example.entity.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AnimalHelper {

    private SessionFactory factory;

    public AnimalHelper() {
        factory = HibernateUtil.getFactory();
    }

    public List<Animal> getAnimalList() {

        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Animal> cq = cb.createQuery(Animal.class);

        Query query = session.createQuery(cq);
        List<Animal> animalList = query.getResultList();

        return animalList;
    }

    public Animal getAnimalById(int id) {

        Session session = factory.openSession();
        Animal animal = session.get(Animal.class, id);

        return animal;
    }

    public Animal addAnimal(Animal animal) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.save(animal);

        session.getTransaction().commit();

        session.close();

        return animal;
    }

    public void deleteAnimalById(int id) {

        Session session = factory.openSession();

        session.beginTransaction();

        Animal animal = session.get(Animal.class, id);

        session.detach(animal);

        session.getTransaction().commit();

        session.close();
    }
}
