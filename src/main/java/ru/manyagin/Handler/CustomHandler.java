package ru.manyagin.Handler;

import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MManiagin on 28.07.2017.
 */
@Component
public class CustomHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String roles = authentication.getAuthorities().toString();
        if(roles.contains("ROLE_ADMIN")){
            response.sendRedirect("/admin");
        }else {
            response.sendRedirect("/user");
        }
    }
}
