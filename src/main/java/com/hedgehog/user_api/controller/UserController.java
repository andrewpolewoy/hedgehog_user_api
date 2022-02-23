package com.hedgehog.user_api.controller;

import com.hedgehog.user_api.model.User;
import com.hedgehog.user_api.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Api(value="UserController", description="Register and validation user")
public class UserController {


    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    @ApiOperation(value = "Returns page with a message about the status of registration")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Registration completed successfully"),
            @ApiResponse(code = 400, message = "Bad Request")
    }
    )
    public String userRegistration(@RequestParam(name = "firstName") String firstName,
                                   @RequestParam(name = "lastName") String lastName,
                                   HttpServletRequest req) {
        try {
            User user = userService.registerUser(firstName, lastName);
            req.setAttribute("firstName", user.getFirstName());
            req.setAttribute("lastName", user.getLastName());
            req.setAttribute("error", true);
            req.setAttribute("message", "Регистрация прощла успешно");
            return "registration";

        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            return "registration";
        }
    }
    @PostMapping("/validation")
    @ApiOperation(value = "Returns page with a message about the number of registered users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Validation completed successfully"),
            @ApiResponse(code = 400, message = "Bad Request")
    }
    )
    public String userValidation(@RequestParam(name = "firstName") String firstName,
                                   HttpServletRequest req) {
        try {
            List<User> user = userService.getUserByFirstName(firstName);
            if (user.isEmpty()){
                req.setAttribute("userMessage", true);
                req.setAttribute("message", "пользователя с таким именем не существует");
            }else {
                int size = user.size();
                req.setAttribute("userMessage", true);
                req.setAttribute("message","количество пользователей с таким именем " + size);
            }
            return "validation";
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            return "validation";
        }
    }

    @PostMapping("/cabinet/users")
    @ApiOperation(value = "Submitting a name from a user search form")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Name accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    }
    )
    public String addUser(@RequestParam(name = "name") String name,
                          HttpServletRequest req) {
        req.setAttribute("name", name);
        return "users";
    }
}
