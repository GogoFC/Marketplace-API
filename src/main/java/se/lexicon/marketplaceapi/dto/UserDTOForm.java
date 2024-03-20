package se.lexicon.marketplaceapi.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOForm {


    private String email;

    private String password;

    private String username;

    private String lastName;

    private String firstName;


}
