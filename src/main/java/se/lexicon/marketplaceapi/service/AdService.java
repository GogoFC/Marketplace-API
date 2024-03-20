package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.dto.AdDTOForm;
import se.lexicon.marketplaceapi.dto.AdDTOView;
import se.lexicon.marketplaceapi.dto.UserDTOForm;

public interface AdService {

    AdDTOView postAd (AdDTOForm adDTOForm);

    //AdDTOView postAd (AdDTOForm adDTOForm, UserDTOForm userDTOForm);

    AdDTOView removeAd (AdDTOForm adDTOForm);
}
