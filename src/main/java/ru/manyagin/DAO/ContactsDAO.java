package ru.manyagin.DAO;

import ru.manyagin.Contacts.Contact;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by MManiagin on 31.07.2017.
 */
public interface ContactsDAO {
    Set<Contact> getAllContact(String contactOwner);
}
