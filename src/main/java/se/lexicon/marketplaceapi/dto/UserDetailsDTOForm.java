package se.lexicon.marketplaceapi.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsDTOForm {

    private String firstName;

    private String lastName;
}
