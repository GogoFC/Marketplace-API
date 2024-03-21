package se.lexicon.marketplaceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.exception.UserNotFoundException;
import se.lexicon.marketplaceapi.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AdService adService;


    @Autowired
    public UserServiceImpl( UserRepository userRepository, PasswordEncoder passwordEncoder, AdService adService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.adService = adService;

    }

    @Override
    public User addUser(User user) {
        //User user = new User(userDTOForm.getEmail(), passwordEncoder.encode(userDTOForm.getPassword()));
        //User user1 = new User(userDTOForm.getEmail(),userDTOForm.getUsername(),passwordEncoder.encode(userDTOForm.getPassword()),userDTOForm.getFirstName(),userDTOForm.getLastName());


        // Below gave error. Username was email and email was password in database
        // User user = new User(userDTOForm.getUsername(), passwordEncoder.encode(userDTOForm.getPassword()), userDTOForm.getEmail());

        /*
        AdDTOView ad = adService.postAd(AdDTOForm.builder()
                        .description(userDTOForm.getAdvert().getDescription())
                        .title(userDTOForm.getAdvert().getDescription())
                .build());

         */

        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = getSpecificUser(id);
        userRepository.delete(user);
        return user;
    }



    @Override
    public User postAd(Long userId, Long adId) {
        User user = getSpecificUser(userId);
        Ad ad = adService.getSpecificAd(adId);
        user.addAdvertisement(ad);
        return user;
    }

    @Override
    public User removeAd(Long userId, Long adId) {
        User user = getSpecificUser(userId);
        Ad ad = adService.getSpecificAd(adId);
        user.removeAdvertisement(ad);
        return user;
    }

    @Override
    public User getSpecificUser(Long id) {
        return userRepository.findById(id).orElseThrow(()->
                new UserNotFoundException(id));
    }

    @Override
    public Set<User> getAllUsers() {
        //return new HashSet<>(userRepository.findAll());
        return StreamSupport
                .stream(userRepository.findAll().spliterator(),false)
                .collect(Collectors.toSet());
    }

    @Override
    public User changeUserPassword(Long id, User user) {
        return null;
    }
}
