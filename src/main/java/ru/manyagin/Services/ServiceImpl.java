package ru.manyagin.Services;

import org.springframework.stereotype.Component;

/**
 * Created by MManiagin on 26.07.2017.
 */
@Component("serviceImpl")
public class ServiceImpl implements MyService {
    public String getMessage() {
        return "MyMessage";
    }
}
