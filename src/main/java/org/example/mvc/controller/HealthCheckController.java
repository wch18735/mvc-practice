package org.example.mvc.controller;

import org.example.annotation.ControllerAnnotation;
import org.example.annotation.RequestMapping;
import org.example.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAnnotation
public class HealthCheckController {
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response){
        return "home";
    }
}
