package se.lexicon.marketplaceapi.dto;

import jakarta.jws.soap.SOAPBinding;
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

    private UserDTOForm userDTOForm;

    private User user;




}
