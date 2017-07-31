package ru.manyagin.DAO;

import ru.manyagin.Users.User;
import ru.manyagin.Users.UserInterface;

import java.util.List;
import java.util.Set;

/**
 * Created by MManiagin on 26.07.2017.
 */
public interface UserDAO {
     void addUser(UserInterface userInterface);
     List<User> showUsers();
}
