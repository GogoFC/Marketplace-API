package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.entity.User;

import java.util.Set;

public interface UserService {

    User addUser (User user);

    User deleteUser (Long id);

    User postAd (Long userId, Long adId);

    User removeAd (Long userId, Long adId);

    Set<User> getAllUsers();

    User getSpecificUser (Long id);

    //User changeUserPassword (Long id, User user);



}
