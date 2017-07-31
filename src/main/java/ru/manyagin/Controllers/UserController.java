package ru.manyagin.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by MManiagin on 26.07.2017.
 */
@Controller
public class UserController {
   /* @Autowired
    MyService myService;*/
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("Content/user");
        //System.out.println(myService.getMessage());

        MainController.printUserDetails();
        return modelAndView;
    }
}
