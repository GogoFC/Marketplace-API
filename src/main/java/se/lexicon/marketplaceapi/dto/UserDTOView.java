package se.lexicon.marketplaceapi.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOView {

    private String email;

    private String username;

    private String lastName;

    private String firstName;


}
