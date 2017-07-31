package ru.manyagin.Users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MManiagin on 28.07.2017.
 */
@Entity
@Table(name = "groups", schema = "security")
public class Groups implements Serializable{
    @Id
    @Column(name = "id")
    private int id = 1;
    private String group_name = "users";

    @OneToOne(mappedBy = "groups", cascade = CascadeType.REFRESH)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
