package ru.manyagin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.manyagin.DAO.UserDAO;
import ru.manyagin.DAO.UserDAOImpl;

/**
 * Created by MManiagin on 26.07.2017.
 */
@Controller
public class AdminController {
    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdminPage(ModelAndView modelAndView) {
        modelAndView.setViewName("/Content/admin");
        modelAndView.addObject("usersList", userDAO.showUsers());
        MainController.printUserDetails();
        return modelAndView;
    }

}
