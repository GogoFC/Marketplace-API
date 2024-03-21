package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.entity.Ad;

import java.util.Set;

public interface AdService {

    Ad saveAd(Ad ad);

    //AdDTOView postAd (AdDTOForm adDTOForm, UserDTOForm userDTOForm);

    Ad deleteAd(Long id);

    Set<Ad> getAllAds();

    Ad getSpecificAd (Long id);

    Ad editAd(Long id, Ad ad);


}
