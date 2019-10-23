package ru.ten.crud.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//import ru.ten.crud.model.User;
import ru.ten.crud.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoHibernateImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> selectAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void editUser(User user) {
        em.merge(user);
    }

    @Override
    public void removeUser(int id) {
        TypedQuery<User> query = em.createQuery("DELETE from User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

}
