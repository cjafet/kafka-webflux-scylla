package com.cjafet.reactive.controller;

import com.cjafet.reactive.model.User;
import com.cjafet.reactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
// All request to user to come to this Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("user")
    private UserRepository userRepository;


    @GetMapping
    public @ResponseBody Flux<User> list() {

        List<User> users = (List<User>) userRepository.findAll();

        // will stream the users collection back to our ui
        Flux<User> fluxUsers = Flux.fromIterable(users);

        return fluxUsers;
    }


    // @Method Method to Request User by Id
    // @Return the response as a stream
    // @ResponseBody Mono<Users>
    // The response is our Mono object, the stream we are going to return
    @GetMapping("{id}")
    public @ResponseBody Mono<User> findById(@PathVariable Long id) {
        // New Java Optional object to wrap a User object
        // This query could return an empty or null result
        Optional<User> user = userRepository.findById(id);
        // Build the response as a stream
        return Mono.just(user.orElse(User.empty()));
    }

    @PutMapping("{id}")
    public @ResponseBody Mono<User> update(@RequestBody User user, @PathVariable long id) {

        //Optional<User> updateUser = userRepository.findById(id);

        User newUser = new User();
        newUser.setId(id);
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        User updateUser = userRepository.save(newUser);

        return Mono.just(updateUser);

        //return Mono.just(updateUser.orElse(User.empty()));


        //User newUser = user;
        //userRepository.save(newUser);
    }

    @PostMapping
    public @ResponseBody Mono<User> add(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return Mono.just(newUser);

        //Flux<User> fluxUser = Flux.just(newUser);
        //return fluxUser;
    }

}
