package ru.manyagin.Contacts;

/**
 * Created by MManiagin on 02.08.2017.
 */
public class ContactBuilderImpl {
    private int id;
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private String mobilePhoneNumber = "";
    private String homePhoneNumber = "";
    private String workPhoneNumber = "";
    private String email = "";
    private String contactOwner = "";
    private String group = "";

    public ContactBuilderImpl setId(int id){
        this.id=id;
        return this;
    }
    public ContactBuilderImpl setfirstName(String firstName){
        this.firstName=firstName;
        return this;
    }
    public ContactBuilderImpl setLastName(String lastName){
        this.lastName=lastName;
        return this;
    }
    public ContactBuilderImpl setMiddleName(String middleName){
        this.middleName=middleName;
        return this;
    }
    public ContactBuilderImpl setMobilePhoneNumber(String mobilePhoneNumber){
        if (mobilePhoneNumber.equals("")){
            this.mobilePhoneNumber=null;
            return this;
        }else{
        this.mobilePhoneNumber=mobilePhoneNumber;
        return this;}
    }
    public ContactBuilderImpl setHomePhoneNumber(String homePhoneNumber){
        if (mobilePhoneNumber.equals("")){
            this.homePhoneNumber=null;
            return this;
        }else{
        this.homePhoneNumber=homePhoneNumber;
        return this;
        }
    }
    public ContactBuilderImpl setWorkPhoneNumber(String workPhoneNumber){
        if (workPhoneNumber.equals("")){
            this.workPhoneNumber=null;
            return this;
        }else {
            this.workPhoneNumber = workPhoneNumber;
            return this;
        }
    }
    public ContactBuilderImpl setEmail(String email){
        if (email.equals("")){
            this.email=null;
            return this;
        }else{
        this.email=email;
        return this;
        }
    }
    public ContactBuilderImpl setContactOwner(String contactOwner){
        this.contactOwner=contactOwner;
        return this;
    }
    public ContactBuilderImpl setGroup(String group){
        if (group.equals("")){
            this.group=null;
            return this;
        }else {
            this.group = group;
            return this;
        }
    }
    public Contact build(){
        ContactImpl contact= new ContactImpl();
        contact.setId(id);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setMiddleName(middleName);
        contact.setMobilePhoneNumber(mobilePhoneNumber);
        contact.setHomePhoneNumber(homePhoneNumber);
        contact.setWorkPhoneNumber(workPhoneNumber);
        contact.setEmail(email);
        contact.setContactOwner(contactOwner);
        contact.setGroup(group);
        return contact;
    }





}
