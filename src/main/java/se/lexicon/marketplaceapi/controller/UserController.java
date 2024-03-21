package se.lexicon.marketplaceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.dto.AdDTO;
import se.lexicon.marketplaceapi.dto.UserDTO;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.service.UserService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody final UserDTO userDTO){
        User user = userService.addUser(User.from(userDTO));
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<UserDTO>> getUsers(){
        Set<User> users = userService.getAllUsers();
        Set<UserDTO> usersDTO = users.stream().map(UserDTO::from).collect(Collectors.toSet());
        return new ResponseEntity<>(usersDTO, HttpStatus.CREATED);
    }
}
