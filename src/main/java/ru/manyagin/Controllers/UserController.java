package ru.manyagin.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.manyagin.Contacts.Contact;
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

        for (Contact c :contactList
             ) {
            System.out.println(c.getFirstName()+" "+ c.getLastName());
        }

        return modelAndView;
    }
}
