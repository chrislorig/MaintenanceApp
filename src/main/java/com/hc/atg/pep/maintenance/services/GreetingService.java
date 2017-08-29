package com.hc.atg.pep.maintenance.services;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by Cris on 29/08/2017.
 */
@ApplicationScoped
public class GreetingService {

    public String getGreeting(){
        return "Hello from service";
    }
}
