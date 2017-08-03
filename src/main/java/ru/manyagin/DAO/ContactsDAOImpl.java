package ru.manyagin.DAO;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.manyagin.Contacts.Contact;
import ru.manyagin.Contacts.ContactImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MManiagin on 31.07.2017.
 */
/*FIXME*/
@Component
public class ContactsDAOImpl implements ContactsDAO{
    @Autowired
    @Qualifier("contactsSessionFactory")
    SessionFactory sessionFactory;

    public Set<Contact> getAllContact(String contactOwner) {
        String owner = contactOwner;
        Set <Contact> contacts=null;
        Session session = sessionFactory.openSession();

        try{
            contacts=new HashSet<Contact>(session.createQuery("from ContactImpl where contactOwner like :own")
                    .setParameter("own", contactOwner).list());

        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return contacts;
    }

    public void updateContact(Contact contact) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(contact);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
