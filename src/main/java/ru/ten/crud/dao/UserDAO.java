package ru.ten.crud.dao;

import ru.ten.crud.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void editUser(User user) throws SQLException;

    void removeUser(int id) throws SQLException;

    User getUserById(int id) throws SQLException;

    List selectAllUsers();

}
