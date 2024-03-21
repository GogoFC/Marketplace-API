package se.lexicon.marketplaceapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.AdDTOForm;
import se.lexicon.marketplaceapi.dto.AdDTOView;
import se.lexicon.marketplaceapi.dto.UserDTOForm;
import se.lexicon.marketplaceapi.dto.UserDTOView;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.repository.AdRepository;
import se.lexicon.marketplaceapi.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AdRepository adRepository;

    private final AdService adService;


    @Autowired
    public UserServiceImpl( UserRepository userRepository, PasswordEncoder passwordEncoder, AdService adService, AdRepository adRepository) {
        this.adRepository = adRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.adService = adService;

    }

    @Override
    public UserDTOView register(UserDTOForm userDTOForm) {
        User user = new User(userDTOForm.getEmail(), passwordEncoder.encode(userDTOForm.getPassword()));
        //User user1 = new User(userDTOForm.getEmail(),userDTOForm.getUsername(),passwordEncoder.encode(userDTOForm.getPassword()),userDTOForm.getFirstName(),userDTOForm.getLastName());


        // Below gave error. Username was email and email was password in database
        // User user = new User(userDTOForm.getUsername(), passwordEncoder.encode(userDTOForm.getPassword()), userDTOForm.getEmail());

        /*
        AdDTOView ad = adService.postAd(AdDTOForm.builder()
                        .description(userDTOForm.getAdvert().getDescription())
                        .title(userDTOForm.getAdvert().getDescription())
                .build());

         */


        User savedUser = userRepository.save(user);

        adService.postAd(userDTOForm.getAdvert());

        /*
        Set<AdDTOView> adDTOViews = savedUser.getAdvertisements()
                .stream()
                .map(
                        ad -> AdDTOView.builder()
                                .title(ad.getTitle())
                                .description(ad.getDescription())
                                .build()

                ).collect(Collectors.toSet());

         */









        return UserDTOView.builder()
                .email(savedUser.getEmail())
                .build();

    }

    /*
    public UserDTOView postAdvertisement(UserDTOForm userDTOForm) {

    }

     */

    @Override
    public UserDTOView postAd(UserDTOForm userDTOForm) {

        return null;
    }

    //TODO
    @Override
    public UserDTOView deactivate(UserDTOForm userDTOForm) {
        return null;
    }
}
