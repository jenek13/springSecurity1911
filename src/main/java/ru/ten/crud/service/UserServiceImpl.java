package ru.ten.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ten.crud.dao.UserDAO;
import ru.ten.crud.exception.DBException;
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

    /*@Override
    public User getUserbyLoginPassword(String login, String password) throws SQLException {
        return (User) userDAO.selectUserByLoginPassword(login, password);
    }*/



    /*@Override
    public void insertUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (Exception e) {
            //LOGGER.fatal("Can`t add user: " + e.getMessage());
        }
    }*/


    /*@Override
    public void insertUserByLogin(String name, int age) throws SQLException {
            User newUser = new User(name, age);
        try {
              userDAO.addUser(newUser);
        } catch (DBException db) {
            for (Throwable e : db) {
                if (e instanceof DBException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((DBException) e).getSQLState());
                    System.err.println("Error Code: " + ((DBException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = db.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }*/

    @Override
    public void updateUser(int id, String name, int age) {
            User newUser = new User(id, name, age);
                try {
                    userDAO.editUser(newUser);
                } catch (SQLException db) {
                    System.err.println(db.getMessage());
                }
            }


}
