package se.lexicon.marketplaceapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.dto.UserDetailsDTOForm;
import se.lexicon.marketplaceapi.dto.UserDetailsDTOView;
import se.lexicon.marketplaceapi.service.UserDetailsService;

@RequestMapping("/api/v1/users/details")
@RestController
public class UserDetailsController {

    UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDetailsDTOView> addName (@RequestBody @Valid UserDetailsDTOForm userDetailsDTOForm){
        UserDetailsDTOView nameAdded = userDetailsService.addName(userDetailsDTOForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(nameAdded);
    }
}
