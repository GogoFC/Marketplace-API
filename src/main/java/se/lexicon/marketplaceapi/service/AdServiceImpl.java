package se.lexicon.marketplaceapi.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.exception.AdNotFoundException;
import se.lexicon.marketplaceapi.repository.AdRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;



    @Autowired
    public AdServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;

    }

    @Override
    public Ad postAd(Ad ad) {
        return adRepository.save(ad);
    }

    @Override
    public Ad removeAd(Long id) {
        Ad ad = getSpecificAd(id);
        adRepository.delete(ad);
        return ad;
    }

    @Override
    @Transactional
    public Ad editAdTitle(Long id, Ad ad) {
        Ad adToEdit = getSpecificAd(id);
        adToEdit.setTitle(ad.getTitle());
        return adToEdit;
    }

    @Override
    @Transactional
    public Ad editAdDescription(Long id, Ad ad) {
        Ad adToEdit = getSpecificAd(id);
        adToEdit.setDescription(ad.getDescription());
        return adToEdit;
    }

    @Override
    public Set<Ad> getAllAds() {
        return StreamSupport
                .stream(adRepository.findAll().spliterator(),false)
                .collect(Collectors.toSet());
    }

    @Override
    public Ad getSpecificAd(Long id) {
        return adRepository.findById(id).orElseThrow(()->
                new AdNotFoundException(id));
    }
}
