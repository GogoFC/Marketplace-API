package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.dto.UserDTOForm;
import se.lexicon.marketplaceapi.dto.UserDTOView;

public interface UserService {

    UserDTOView register (UserDTOForm userDTOForm);

    UserDTOView deactivate (UserDTOForm userDTOForm);

    UserDTOView postAd (UserDTOForm userDTOForm);

}
