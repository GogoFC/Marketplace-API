package se.lexicon.marketplaceapi.dto;

import lombok.Data;
import se.lexicon.marketplaceapi.entity.Ad;

import java.util.Objects;

@Data
public class AdDTO {

    private Long id;
    private String title;
    private String description;

    public static AdDTO from(Ad ad){
        AdDTO adDTO = new AdDTO();
        adDTO.setId(ad.getId());
        adDTO.setTitle(ad.getTitle());
        adDTO.setDescription(ad.getDescription());
        return adDTO;
    }
}
