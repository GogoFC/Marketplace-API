package se.lexicon.marketplaceapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.marketplaceapi.dto.AdDTOForm;
import se.lexicon.marketplaceapi.dto.AdDTOView;
import se.lexicon.marketplaceapi.service.AdService;

@RestController
@RequestMapping("/api/v1/ad")
public class AdController {

    AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }



    @PostMapping("/")
    public ResponseEntity<AdDTOView> postAd(@RequestBody @Valid AdDTOForm adDTOForm){
        AdDTOView postedAd = adService.postAd(adDTOForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(postedAd);

    }
}
