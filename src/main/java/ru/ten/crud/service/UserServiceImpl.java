package ru.ten.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ten.crud.dao.UserDAO;
import ru.ten.crud.model.User;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User selectUser(int id) throws SQLException {
        return  userDAO.getUserById(id);
    }

    @Override
    public List<User> listUser() {
        return userDAO.selectAllUsers();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        userDAO.removeUser(id);
    }

    @Override
    public void insertUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
            userDAO.editUser(user);
    }

}
