package se.lexicon.marketplaceapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import se.lexicon.marketplaceapi.entity.User;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdDTOForm {

    private String title;

    private String description;

    //@NotNull
    //@Valid
    //private UserDTOForm user;

    //private User user;




}
