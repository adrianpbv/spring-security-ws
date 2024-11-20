package com.eazybytes.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public  String getAccountDetails () {
        return "Here are the account details from the DB";
    }

    @GetMapping("/myUserName")
    public String getUserName() {
        // Get authentication from the securityContext. It contains user's details like username and role
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/myUserName1")
    public String getUserName1(Authentication authentication) {

        return authentication.getName();
    }
}
