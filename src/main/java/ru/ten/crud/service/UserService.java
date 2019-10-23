package ru.ten.crud.service;

import ru.ten.crud.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService<T> {

    User selectUser(int id) throws SQLException;
    List<User> listUser();
    void deleteUser(int id) throws SQLException;
    //User getUserbyLoginPassword(String login, String password) throws SQLException;
    void insertUser(User user);
    //void insertUserByLogin(String name, int age) throws SQLException;
    void updateUser(int id, String name, int age) throws SQLException;;



}
