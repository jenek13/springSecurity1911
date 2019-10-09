package ru.ten.crud.dao;

import ru.ten.crud.exception.DBException;
import ru.ten.crud.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO<Entity> {

    void insertDAO(Entity model) throws SQLException, DBException;

    void updateDAO(User user) throws SQLException;

    boolean deleteDAO(int id) throws SQLException;

    Entity selectUser(int id) throws SQLException;

    String getRoleByLoginPassword(String login, String password) throws SQLException;

    Entity selectUserByLoginPassword(String login, String password) throws SQLException;

    List<Entity> selectAllUsers();

}
