package ru.manyagin.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.manyagin.Users.Groups;
import ru.manyagin.Users.User;
import ru.manyagin.Users.UserInterface;

import java.util.HashSet;
import java.util.List;


/**
 * Created by MManiagin on 26.07.2017.
 */
@Component
public class UserDAOImpl implements UserDAO{

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    public void addUser(UserInterface userInterface){
        Session session = sessionFactory.openSession();
        User user = new User(userInterface.getUsername(), userInterface.getPassword());
        Groups groups = new Groups();
        user.setGroups(groups);

        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

    public List<User> showUsers(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users=session.createQuery("FROM User").list();
        session.getTransaction().commit();
        return users;
    }

}
