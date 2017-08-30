package com.hc.atg.pep.maintenance.controllers;

import com.hc.atg.pep.maintenance.services.GreetingService;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


/**
 * Created by Cris on 29/08/2017.
 */
@ApplicationScoped
@Produces(APPLICATION_JSON)
@Path("greetings")
public class GreetingResource {
    @Inject
    private GreetingService greetingService;

    @GET
    public String get(){
        return  "hello";
    }

    @GET
    @Path("injectedgreeting")
    public  String getGreetingService(){
        return greetingService.getGreeting();
    }
}
