package se.lexicon.marketplaceapi.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdDTOForm {

    private String title;

    private String description;

    private UserDTOForm userDTOForm;




}
