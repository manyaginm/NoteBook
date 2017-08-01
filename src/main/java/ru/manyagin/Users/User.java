package ru.manyagin.Users;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by MManiagin on 26.07.2017.
 */
@Component
@Entity
@Table (name = "users", schema = "security")

public class User implements UserInterface{

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

    @Id
    @Column(name = "username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name = "enabled")
    private int enabled = 1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "group_members",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Groups groups;

    public Groups getGroups() {
        return groups;
    }
    public User(){}
    public User(String username, String password, int enabled){
        this.username=username;
        this.password=password;
        this.enabled=enabled;
    }



    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj==this){return true;}
        if(obj==null||obj.getClass()!=this.getClass()){
            return false;
        }
       User user = (User)obj;
        return this.getUsername().equals(user.getUsername());

    }

    @Override
    public int hashCode() {
        int hashcode=0;
        char[] arr = this.getUsername().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            hashcode = 31 * hashcode+ arr[i];
        }
        return hashcode;
    }
}
