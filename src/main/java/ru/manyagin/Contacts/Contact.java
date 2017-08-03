package ru.manyagin.Contacts;

import org.json.simple.JSONObject;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MManiagin on 31.07.2017.
 */
public interface Contact extends Serializable{

    int getId();
    void setId(int id);
    String getFirstName();
    void setFirstName(String firstName) ;
    String getLastName();
    void setLastName(String lastName);
    String getMiddleName();
    void setMiddleName(String middleName);
    String getMobilePhoneNumber();
    void setMobilePhoneNumber(String mobilePhoneNumber);
    String getHomePhoneNumber();
    void setHomePhoneNumber(String homePhoneNumber);
    String getWorkPhoneNumber();
    void setWorkPhoneNumber(String workPhoneNumber);
    String getEmail();
    void setEmail(String email);
    String getContactOwner();
    void setContactOwner(String contactOwner);
    String getGroup();
    void setGroup(String group);
    String getAsJson();
}
