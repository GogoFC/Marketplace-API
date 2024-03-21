package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.*;
import lombok.*;
import se.lexicon.marketplaceapi.dto.AdDTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(exclude = "user")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;


    @ManyToOne
    private User user;


    public Ad(String title, String description) {

        this.title = title;
        this.description = description;
    }

    public static Ad from(AdDTO adDTO){
        Ad ad = new Ad();
        ad.setTitle(adDTO.getTitle());
        ad.setDescription(adDTO.getDescription());
        return ad;
    }
}
