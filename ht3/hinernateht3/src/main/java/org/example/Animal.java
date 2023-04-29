package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int age;

    @Column
    private String name;

    @Column
    private boolean tail;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isTail() {
        return tail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", tail=" + tail +
                '}';
    }
}
