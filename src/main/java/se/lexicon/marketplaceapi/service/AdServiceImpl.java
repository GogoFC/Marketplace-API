package se.lexicon.marketplaceapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.AdDTOForm;
import se.lexicon.marketplaceapi.dto.AdDTOView;
import se.lexicon.marketplaceapi.dto.UserDTOForm;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.repository.AdRepository;

@Service
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;



    @Autowired
    public AdServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;

    }

    @Override
    public AdDTOView postAd(AdDTOForm adDTOForm) {

        //User user = new User();
        //user.getId();
        //adRepository.save(adDTOForm.getUserDTOForm());
        //Ad ad = new Ad(adDTOForm.getTitle(), adDTOForm.getDescription());
        //Ad ad = new Ad(adDTOForm.getTitle(), adDTOForm.getDescription());
        Ad ad = new Ad(adDTOForm.getTitle(), adDTOForm.getDescription());

        /*
        User user = new User();
        ad.setUser(user);

         */

        Ad savedAd = adRepository.save(ad);




        //User user = new User();

        return AdDTOView.builder()
                .title(savedAd.getTitle())
                .description(savedAd.getDescription())
                .build();


    }

    @Override
    public AdDTOView removeAd(AdDTOForm adDTOForm) {
        return null;
    }
}
