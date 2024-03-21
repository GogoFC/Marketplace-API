package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.dto.AdDTOForm;
import se.lexicon.marketplaceapi.dto.AdDTOView;
import se.lexicon.marketplaceapi.dto.UserDTOForm;
import se.lexicon.marketplaceapi.entity.Ad;

import java.util.Set;

public interface AdService {

    Ad postAd (Ad ad);

    //AdDTOView postAd (AdDTOForm adDTOForm, UserDTOForm userDTOForm);

    Ad removeAd (Long id);

    Set<Ad> getAllAds();

    Ad getSpecificAd (Long id);

    Ad editAdTitle (Long id, Ad ad);

    Ad editAdDescription (Long id, Ad ad);


}
