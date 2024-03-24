package se.lexicon.marketplaceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.dto.AdDTO;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.service.AdService;
import se.lexicon.marketplaceapi.service.UserService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ads")
public class AdController {

    private final AdService adService;
    private final UserService userService;
    @Autowired
    public AdController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AdDTO> saveAd(@RequestBody final AdDTO adDTO) {

        Ad ad = adService.saveAd(Ad.from(adDTO));
        return new ResponseEntity<>(AdDTO.from(ad), HttpStatus.CREATED);
    }

    // Double colon :: is called Branch Operator.
    @GetMapping
    public ResponseEntity<Set<AdDTO>> getAds(){
        Set<Ad> ads = new HashSet<>();
        ads = adService.getAllAds();
        Set<AdDTO> adsDTO = ads.stream().map(AdDTO::from).collect(Collectors.toSet());
        return new ResponseEntity<>(adsDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AdDTO> getSpecificAd(@PathVariable final Long id){
        Ad ad = adService.getSpecificAd(id);
        return new ResponseEntity<>(AdDTO.from(ad), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<AdDTO> deleteAd(@PathVariable final Long id){
        Ad ad = adService.deleteAd(id);
        return new ResponseEntity<>(AdDTO.from(ad), HttpStatus.CREATED);
    }



    @PutMapping(value = "{id}")
    public ResponseEntity<AdDTO> editAd(@PathVariable final Long id,
                                             @RequestBody final AdDTO adDTO){

        Ad editedAd = adService.editAd(id, Ad.from(adDTO));
        return new ResponseEntity<>(AdDTO.from(editedAd), HttpStatus.CREATED);
    }
}
