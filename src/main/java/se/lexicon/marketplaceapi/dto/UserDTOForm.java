package se.lexicon.marketplaceapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOForm {


    private String email;

    private String password;

    @NotNull
    @Valid
    private AdDTOForm advert;



}
