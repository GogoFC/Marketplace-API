package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import se.lexicon.marketplaceapi.dto.UserDTOForm;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Ad {

    @Id
    private Long id;

    private String title;




}
