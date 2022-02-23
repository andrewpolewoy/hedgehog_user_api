package com.hedgehog.user_api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cabinet")
@Api(value="PersonalCabinet", description="Menu mapping")
public class PersonalCabinet {

    @GetMapping("/registration")
    @ApiOperation(value = "Go to registration page")
    public String getRegistrationPage(){
        return "registration";
    }

    @GetMapping("/validation")
    @ApiOperation(value = "Go to validation page")
    public String getValidationPage(){
        return "validation";
    }

    @GetMapping("/users")
    @ApiOperation(value = "Go to user page")
    public String getSearchPage(HttpServletRequest req) {
        req.setAttribute("name", "`");
        return "users";
    }

    @GetMapping
    @ApiOperation(value = "Go to cabinet page")
    public String getUserCabinet(){
        return "cabinet";
    }

}
