package se.lexicon.marketplaceapi.dto;

import jakarta.persistence.Column;
import lombok.Data;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.entity.User;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Set<Ad> ads = new HashSet<>();

    public static UserDTO from(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setPassword(userDTO.getPassword());
        return userDTO;

    }



}
