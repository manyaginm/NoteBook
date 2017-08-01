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



    @Override
    public boolean equals(Object obj) {
        if(obj==this){return true;}
        if(obj==null||obj.getClass()!=this.getClass()){
            return false;
        }
        Groups groups = (Groups)obj;
        return this.getId()==groups.getId()&&this.getGroup_name().equals(groups.getGroup_name());

    }
    @Override
    public int hashCode() {
        int hashcode=0;
        char[] arr = this.getGroup_name().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            hashcode = 31 * hashcode+ arr[i];
        }
        return hashcode;
    }
}
