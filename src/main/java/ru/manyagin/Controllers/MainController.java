package ru.manyagin.Controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by MManiagin on 21.07.2017.
 */
@Controller
public class MainController {

        @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
        public ModelAndView index(@RequestParam(value = "error", required = false) String error, ModelAndView modelAndView) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String roles = auth.getAuthorities().toString();


            if(!(auth instanceof AnonymousAuthenticationToken)){//штука проверят является ли user залогиненым, если да, redirect
                if(roles.contains("ROLE_ADMIN")){
                    return new ModelAndView("forward:/admin");
                }else if(roles.contains("ROLE_USER")){
                    return new ModelAndView("forward:/user");
                }
            }
            if (error != null) {
                modelAndView.addObject("error", "Invalid username or password");
            }
            modelAndView.setViewName("login");
            return modelAndView;
            }



    /*FIXME*/
        @RequestMapping(value = "/AccesDinied", method = RequestMethod.GET)
        public ModelAndView accesDiniedPage(ModelAndView modelAndView, Principal user) {
            if (user != null) {
                modelAndView.addObject("errorMsg", user.getName() + " you have not acces to this page");
            } else {
                modelAndView.addObject("errorMsg", "You have not acces to this page");
            }
            modelAndView.setViewName("Content/AccesDinied");
            return modelAndView;
        }



}
