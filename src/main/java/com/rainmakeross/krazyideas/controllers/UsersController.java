package com.rainmakeross.krazyideas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String generateMsg() {
        return "OK";
    }
}
