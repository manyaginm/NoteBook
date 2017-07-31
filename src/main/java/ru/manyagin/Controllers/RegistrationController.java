package ru.manyagin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.manyagin.DAO.UserDAO;
import ru.manyagin.Users.UserInterface;

/**
 * Created by MManiagin on 26.07.2017.
 */
@Controller
public class RegistrationController {
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserInterface user;


    @RequestMapping(value = "/regisration")
    public ModelAndView registration(ModelAndView modelAndView){
        modelAndView.setViewName("regPage");
        return modelAndView;
    }

    @RequestMapping(value="/regConfirmPage")
    public ModelAndView regConfirm(@RequestParam(value = "userLoginRegPage", required = true) String login,
                                   @RequestParam(value = "userPasswordRegPage", required = true) String password, ModelAndView modelAndView){

       modelAndView.setViewName("regConfirmPage");
       user.setPassword(password);
       user.setUsername(login);
       userDAO.addUser(user);
       modelAndView.addObject("login", login);
       return modelAndView;
    }
}
