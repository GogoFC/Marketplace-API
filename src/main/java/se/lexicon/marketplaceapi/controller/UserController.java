package se.lexicon.marketplaceapi.controller;

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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AdService adService;

    @Autowired
    public UserController(UserService userService, AdService adService) {
        this.userService = userService;
        this.adService = adService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody final UserDTO userDTO){
        User user = userService.addUser(User.from(userDTO));
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<UserDTO>> getUsers(){
        Set<User> users = new HashSet<>();
        users = userService.getAllUsers();
        Set<UserDTO> usersDTO = users.stream().map(UserDTO::from).collect(Collectors.toSet());
        return new ResponseEntity<>(usersDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable final Long id){
        User user = userService.getSpecificUser(id);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable final Long id,
                                              @RequestBody final UserDTO userDTO){
        if (ObjectUtils.notEqual(userDTO.getPassword(), userService.getSpecificUser(id).getPassword())){
            User user = new User();
            return new ResponseEntity<>(UserDTO.from(user), HttpStatus.FORBIDDEN);
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

    @PostMapping(value = "{userId}/ads/{adId}/publish")
    public ResponseEntity<UserDTO> publishAd(@PathVariable final Long userId,
                                          @PathVariable final Long adId){
        User user = userService.postAd(userId, adId);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{userId}/ads/{adId}/unpublish")
    public ResponseEntity<UserDTO> unpublishAd(@PathVariable final Long userId,
                                               @PathVariable final Long adId){
        User user = userService.removeAd(userId, adId);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.CREATED);
    }



    @PostMapping(value ="{userId}/post_ad")
    public ResponseEntity<AdDTO> makeAd(@RequestBody final AdDTO adDTO,
                                        @RequestBody UserDTO userDTO,
                                        @PathVariable final Long userId) {

        if (Objects.equals(userService.getSpecificUser(userId).getPassword(), userDTO.getPassword())){
            Ad ad = adService.saveAd(Ad.from(adDTO));
            //get id from the ad above that was just saved. Not from adDTO.getId.
            userService.postAd(userId,ad.getId());
            return new ResponseEntity<>(AdDTO.from(ad), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
