package se.lexicon.marketplaceapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.UserDTOForm;
import se.lexicon.marketplaceapi.dto.UserDTOView;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.repository.UserRepository;

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
    public UserDTOView register(UserDTOForm userDTOForm) {
        User user = new User(userDTOForm.getEmail(), passwordEncoder.encode(userDTOForm.getPassword()));
        //User user1 = new User(userDTOForm.getEmail(),userDTOForm.getUsername(),passwordEncoder.encode(userDTOForm.getPassword()),userDTOForm.getFirstName(),userDTOForm.getLastName());


        // Below gave error. Username was email and email was password in database
        // User user = new User(userDTOForm.getUsername(), passwordEncoder.encode(userDTOForm.getPassword()), userDTOForm.getEmail());

        User savedUser = userRepository.save(user);


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
