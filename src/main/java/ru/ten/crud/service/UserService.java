package ru.ten.crud.service;

import java.sql.SQLException;
import java.util.List;

public interface UserService<T> {

    void insertUser(String name, int age, String role) throws SQLException;
    void updateUser(int id, String name, int age, String role) throws SQLException;;
    void deleteUser(int id) throws SQLException;
    List<T> listUser();
}
