package se.lexicon.marketplaceapi.dto;

import lombok.Data;
import se.lexicon.marketplaceapi.entity.User;

@Data
public class UsersDTO {
    private Long id;
    private String email;

    public static UsersDTO from(User user){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(user.getId());
        usersDTO.setEmail(user.getEmail());
        return usersDTO;
    }
}
