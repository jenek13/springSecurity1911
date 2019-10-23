package ru.ten.crud.dao;

import ru.ten.crud.exception.DBException;
import ru.ten.crud.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void editUser(User user) throws SQLException;

    void removeUser(int id) throws SQLException;

    User getUserById(int id) throws SQLException;

    //String getRoleByLoginPassword(String login, String password) throws SQLException;

    //User selectUserByLoginPassword(String login, String password) throws SQLException;

    List selectAllUsers();

}
