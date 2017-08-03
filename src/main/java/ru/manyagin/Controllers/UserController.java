package ru.manyagin.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.manyagin.Contacts.Contact;
import ru.manyagin.Contacts.ContactBuilderImpl;
import ru.manyagin.Contacts.ContactImpl;
import ru.manyagin.DAO.ContactsDAO;


import java.util.Set;

/**
 * Created by MManiagin on 26.07.2017.
 */
@Controller
public class UserController {

    @Autowired
    ContactsDAO contactsDAO;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage(ModelAndView modelAndView) {
        UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<Contact> contactList = contactsDAO.getAllContact(userDetail.getUsername().toString());

        modelAndView.setViewName("Content/user");
        modelAndView.addObject("contactList", contactList);
        return modelAndView;
    }


    @RequestMapping(value = "/updateContact", method=RequestMethod.GET)
    public ModelAndView updateContact(
            @RequestParam(value = "editId")int newId,
            @RequestParam(value = "editFirstName") String newFirstName,
            @RequestParam(value = "editLastName") String newLastName,
            @RequestParam(value = "editMiddleName") String newMiddleName,
            @RequestParam(value = "editMobilePhoneNumber") String newMobilePhoneNumber,
            @RequestParam(value = "editWorkPhoneNumber") String newWorkPhoneNumber,
            @RequestParam(value = "editHomePhoneNumber") String newHomePhoneNumber,
            @RequestParam(value = "editEmail") String newEmail,
            @RequestParam(value = "editGroup") String newGroup,
            ModelAndView modelAndView){
            UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Contact contact = new ContactBuilderImpl()
                    .setId(newId)
                    .setfirstName(newFirstName)
                    .setMiddleName(newMiddleName)
                    .setLastName(newLastName)
                    .setMobilePhoneNumber(newMobilePhoneNumber)
                    .setWorkPhoneNumber(newWorkPhoneNumber)
                    .setHomePhoneNumber(newHomePhoneNumber)
                    .setEmail(newEmail)
                    .setGroup(newGroup)
                    .setContactOwner(userDetail.getUsername().toString())
                    .build();

        contactsDAO.updateContact(contact);


        System.out.println(contact.getId()+" "+contact.getFirstName() + " " + contact.getLastName()+" "+ contact.getMobilePhoneNumber());

        Set<Contact> contactList = contactsDAO.getAllContact(userDetail.getUsername().toString());
        modelAndView.addObject("contactList", contactList);
        modelAndView.setViewName("Content/user");
        return modelAndView;
    }
}
