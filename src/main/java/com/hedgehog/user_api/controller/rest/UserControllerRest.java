package com.hedgehog.user_api.controller.rest;

import com.hedgehog.user_api.model.User;
import com.hedgehog.user_api.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cabinet")
@Api(value="UserControllerRest", description="Getting by name and deleting users")
public class UserControllerRest {

    private final IUserService userService;

    @Autowired
    public UserControllerRest(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{name}")
    @ApiOperation(value = "Returns a list of found users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 400, message = "Bad Request")
    }
    )
    public ResponseEntity<List<User>> findUser(@PathVariable(name = "name") String name,
                                               HttpServletRequest req) {

        List<User> users = userService.findByFirstNameContainingIgnoreCase(name);
        req.setAttribute("name", name);

        return  users.isEmpty()
                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    @ApiOperation(value = "Deleting a user by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User deleted successfully"),
            @ApiResponse(code = 304, message = "Bad Request")
    }
    )
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
