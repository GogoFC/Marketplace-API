package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.dto.UserDetailsDTOForm;
import se.lexicon.marketplaceapi.dto.UserDetailsDTOView;

public interface UserDetailsService {

    UserDetailsDTOView addName(UserDetailsDTOForm userDetailsDTOForm);
}
