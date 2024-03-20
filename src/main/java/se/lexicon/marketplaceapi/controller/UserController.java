package se.lexicon.marketplaceapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.marketplaceapi.dto.UserDTOForm;
import se.lexicon.marketplaceapi.dto.UserDTOView;
import se.lexicon.marketplaceapi.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/")
    public ResponseEntity<UserDTOView> register(@RequestBody @Valid UserDTOForm userDTOForm){
        UserDTOView registered = userService.register(userDTOForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(registered);
    }




    /*
    @PostMapping("/")
    public UserDTOView register(@RequestBody @Valid UserDTOForm userDTOForm) {
        return userService.register(userDTOForm);
    }
    //This also works. Delegate Method

     */

}
