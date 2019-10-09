package ru.ten.crud.dao;

import org.hibernate.SessionFactory;
import ru.ten.crud.util.DBHelper;
import ru.ten.crud.util.PropertyReader;

import java.sql.Connection;

public class UserDaoFactory {

    public static UserDAO getUserDAO(){

        if (PropertyReader.getValue("technology", "currentTechnology.properties").equalsIgnoreCase("hibernate")){
            SessionFactory sessionFactory = DBHelper.getSessionFactory();
            return new UserDaoHibernateImpl(sessionFactory);
        }/*else{
            Connection connection = DBHelper.getDbConnection();
            return new UserDaoJDBCimpl(connection);
        }*/
        return null;
    }
}
