package se.lexicon.marketplaceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.UserDetailsDTOForm;
import se.lexicon.marketplaceapi.dto.UserDetailsDTOView;
import se.lexicon.marketplaceapi.entity.UserDetails;
import se.lexicon.marketplaceapi.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetailsDTOView addName(UserDetailsDTOForm userDetailsDTOForm) {

        UserDetails firstAndLastName = new UserDetails(userDetailsDTOForm.getFirstName(),userDetailsDTOForm.getLastName());

        UserDetails savedNameDetails = userDetailsRepository.save(firstAndLastName);

        return UserDetailsDTOView.builder()
                .firstName(savedNameDetails.getFirstName())
                .lastName(savedNameDetails.getLastName())
                .build();
    }
}
