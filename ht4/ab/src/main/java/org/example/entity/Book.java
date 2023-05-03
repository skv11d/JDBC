package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long authorId;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
