package se.lexicon.marketplaceapi.controller;

import jakarta.validation.Valid;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.dto.AdDTO;
import se.lexicon.marketplaceapi.dto.UserDTO;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.service.AdService;
import se.lexicon.marketplaceapi.service.UserService;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final AdService adService;

    @Autowired
    public UserController(UserService userService, AdService adService) {
        this.userService = userService;
        this.adService = adService;
    }

    @PostMapping(value = "users")
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid final UserDTO userDTO){
        User user = userService.addUser(User.from(userDTO));
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "users")
    public ResponseEntity<Set<UserDTO>> getUsers(){
        Set<User> users = new HashSet<>();
        users = userService.getAllUsers();
        Set<UserDTO> usersDTO = users.stream().map(UserDTO::from).collect(Collectors.toSet());
        return new ResponseEntity<>(usersDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable final Long id){
        User user = userService.getSpecificUser(id);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable final Long id,
                                              @RequestBody final UserDTO userDTO){
        if (ObjectUtils.notEqual(userDTO.getPassword(), userService.getSpecificUser(id).getPassword())){
            User user = new User();
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        User user = userService.deleteUser(id);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.ACCEPTED);
    }

    /*
    @PutMapping(value = "{id}")
    public ResponseEntity<UserDTO> changeUserPassword(@PathVariable final Long id,
                                                      @RequestBody final UserDTO userDTO){

        if (Objects.equals(userDTO.getPassword(), userService.getSpecificUser(id))){
            User user = userService.changeUserPassword(id, User.from(userDTO));
            return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
        }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

     */

    @PostMapping(value = "users/{userId}/ads/{adId}/publish")
    public ResponseEntity<UserDTO> rePostAd(@PathVariable final Long userId,
                                            @PathVariable final Long adId,
                                            @RequestBody final UserDTO userDTO){

        if (Objects.equals(userService.getSpecificUser(userId).getPassword(),userDTO.getPassword())){
            User user = userService.postAd(userId, adId);
            return new ResponseEntity<>(UserDTO.from(user), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping(value = "users/{userId}/ads/{adId}/unpublish")
    public ResponseEntity<UserDTO> unPublishAd(@PathVariable final Long userId,
                                               @PathVariable final Long adId,
                                               @RequestBody final UserDTO userDTO){
        if (Objects.equals(userService.getSpecificUser(userId).getPassword(), userDTO.getPassword())){
            User user = userService.removeAd(userId, adId);
            return new ResponseEntity<>(UserDTO.from(user), HttpStatus.ACCEPTED);
        }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }



    @PostMapping(value ="/users/{userId}/post_ad")
    public ResponseEntity<AdDTO> makeAd(@RequestBody final AdDTO adDTO,
                                        @PathVariable final Long userId) {


        if (Objects.equals(userService.getSpecificUser(userId).getPassword(), adDTO.getPassword())){
            Ad ad = adService.saveAd(Ad.from(adDTO));
            //get id from the ad above that was just saved. Not from adDTO.getId.
            userService.postAd(userId,ad.getId());
            return new ResponseEntity<>(AdDTO.from(ad), HttpStatus.CREATED);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping(value = "/ads/{id}")
    public ResponseEntity<AdDTO> deleteAd(@RequestBody UserDTO userDTO,
                                          @PathVariable final Long id
                                          ){


        if (Objects.equals(userService.getSpecificUser(userDTO.getId()).getPassword(), userDTO.getPassword())){
            Ad ad = adService.deleteAd(id);
            return new ResponseEntity<>(AdDTO.from(ad), HttpStatus.CREATED);
        }



        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }



    @PutMapping(value = "/ads/{id}")
    public ResponseEntity<AdDTO> editAd(@PathVariable final Long id,
                                        @RequestBody final AdDTO adDTO){

        Ad editedAd = adService.editAd(id, Ad.from(adDTO));
        return new ResponseEntity<>(AdDTO.from(editedAd), HttpStatus.CREATED);
    }

}
