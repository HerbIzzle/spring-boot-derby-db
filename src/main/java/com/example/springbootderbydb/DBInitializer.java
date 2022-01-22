package com.example.springbootderbydb;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

@Component
public class DBInitializer {
    @Autowired
    private UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationReady() {
        userRepository.saveAll(List.of(
                new User("Herbert", "Knaf", "1990-12-12", true),
                new User("Tommy", "Wright", "1980-02-21", false),
                new User("Andi", "Goldberger", "2007-11-04", true),
                new User("Hannah", "Pohn", "1998-12-29", true),
                new User("David", "Rasche", "1987-05-04", false)
        ));
    }
}