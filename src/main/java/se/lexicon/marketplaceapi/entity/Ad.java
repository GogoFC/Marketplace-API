package se.lexicon.marketplaceapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
}
