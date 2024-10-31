package br.com.rts.estudos.java21.infrastructure.controllers;

import br.com.rts.estudos.java21.domain.User;
import br.com.rts.estudos.java21.infrastructure.controllers.requests.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public User create(@RequestBody UserRequest userRequest){

        return User.create(userRequest.email(), userRequest.passwordType(), userRequest.plainPassword());
    }
}
