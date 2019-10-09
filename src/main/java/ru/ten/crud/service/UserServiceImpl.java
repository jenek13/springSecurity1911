package ru.ten.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ten.crud.dao.UserDAO;
import ru.ten.crud.exception.DBException;
import ru.ten.crud.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements ru.ten.crud.service.UserService {


    private static UserServiceImpl userServiceImpl;
    @Autowired
    UserDAO userDAO;

        public List<User> listUser() {
            return userDAO.selectAllUsers();
        }







        public void deleteUser(int id) throws SQLException {
            userDAO.deleteDAO(id);
        }

        public User selectUser(int id) throws SQLException {
            return (User) userDAO.selectUser(id);
        }

        public User getUserbyLoginPassword(String login, String password) throws SQLException {
            return (User) userDAO.selectUserByLoginPassword(login, password);
        }

        public void insertUser(String name, int age, String role) throws SQLException {
            User newUser = new User(name, age, role);
            try {
                userDAO.insertDAO(newUser);
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
        }


        public void insertUserByLogin(String login, String password, String name, int age, String role) throws SQLException {
            User newUser = new User(login, password, name, age,role);
        try {
              userDAO.insertDAO(newUser);
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
        }

        public void updateUser(int id, String name, int age, String role) {
            User newUser = new User(id, name, age, role);
                try {
                    userDAO.updateDAO(newUser);
                } catch (SQLException db) {
                    System.err.println(db.getMessage());//7 пункт
                }
            }
        }
