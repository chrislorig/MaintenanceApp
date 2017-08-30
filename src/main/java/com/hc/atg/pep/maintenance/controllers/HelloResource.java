package com.hc.atg.pep.maintenance.controllers;

import com.hc.atg.pep.maintenance.services.GreetingService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


/**
 * Created by Cris on 29/08/2017.
 */
@ApplicationScoped
@Produces(APPLICATION_JSON)
@Path("hello")
public class HelloResource {
    @Inject
    private GreetingService greetingService;

    @GET
    public String get(){
        return  "hello";
    }

    @GET
    @Path("greetingService")
    public  String getGreetingService(){
        return greetingService.getGreeting();
    }
}
