package se.lexicon.marketplaceapi.service;

import jakarta.jws.soap.SOAPBinding;
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

    @Autowired
    public UserServiceImpl( UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public UserDTOView register(UserDTOForm userDTOForm) {
        User user = new User(userDTOForm.getUsername(), passwordEncoder.encode(userDTOForm.getPassword()),userDTOForm.getEmail());

        User savedUser = userRepository.save(user);

        return UserDTOView.builder()
                .email(savedUser.getEmail())
                .build();

    }

    //TODO
    @Override
    public UserDTOView deactivate(UserDTOForm userDTOForm) {
        return null;
    }
}
