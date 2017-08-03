package ru.manyagin.Contacts;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by MManiagin on 31.07.2017.
 */
@Component
@Entity()
@Table(name = "userdetails")
public class ContactImpl implements Contact{

    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobilePhoneNumber;
    private String homePhoneNumber;
    private String workPhoneNumber;
    private String email;
    private String contactOwner;
    private String group;
    private String asJson;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "FirstName")
    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LastName")
    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "MiddleName")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "MobilePhoneNumber")
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
    @Column(name = "HomePhoneNumber")
    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    @Column(name = "WorkPhoneNumber")
    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ContactOwner")
    @NotNull
    public String getContactOwner() {
        return contactOwner;
    }

    public void setContactOwner(String contactOwner) {
        this.contactOwner = contactOwner;
    }

    @Column(name = "ContactGroup")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){return true;}
        if(obj==null||obj.getClass()!=this.getClass()){
            return false;
        }
        ContactImpl contact= (ContactImpl) obj;
        return this.getId()==contact.getId()
                &&this.getFirstName().equals(contact.getFirstName())
                &&this.getLastName().equals(contact.getLastName())
                &&this.getContactOwner().equals(contact.getContactOwner());
    }

    @Override
    public int hashCode() {
        int hashcode=0;
        char[] arr = (this.getFirstName()+" " + this.getLastName()+" "+this.getMiddleName()+
                " "+this.getId() + this.getContactOwner()).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            hashcode = 31 * hashcode+ arr[i];
        }
        return hashcode;
    }

    @Transient
    public String getAsJson() {
        JSONObject jo = new JSONObject();
        jo.put("id", this.id);
        jo.put("firstName", this.firstName);
        jo.put("lastName", this.lastName);
        jo.put("middleName", this.middleName);
        jo.put("mobilePhoneNumber", this.mobilePhoneNumber);
        jo.put("homePhoneNumber", this.homePhoneNumber);
        jo.put("workPhoneNumber", this.workPhoneNumber);
        jo.put("email", this.email);
        jo.put("contactOwner", this.contactOwner);
        jo.put("group", this.group);
        return jo.toString();
    }

}
