package ru.manyagin.Users;

import java.io.Serializable;

/**
 * Created by MManiagin on 27.07.2017.
 */
public interface UserInterface extends Serializable{
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);
}
