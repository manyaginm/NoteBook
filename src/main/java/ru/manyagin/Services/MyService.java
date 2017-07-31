package ru.manyagin.Services;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 * Created by MManiagin on 26.07.2017.
 */

public interface MyService {
    /*В данном случае, у данной роли есть доступ на уровне на уровне запроса, но нет доступа на уровне метода, поэтому
    * при попытке доступа к странице, появиться accesDeniedPage*/
    @Secured("ROLE_ADMIN")
     String getMessage();
}
