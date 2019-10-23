package ru.ten.crud.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "newuser")//todo вот здесь имя таблицы а было неверное
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;



    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
