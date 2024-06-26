package se.lexicon.marketplaceapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import se.lexicon.marketplaceapi.entity.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private Long id;
    private String email;
    @NotBlank
    private String password;
    private Set<AdDTO> adsDTO = new HashSet<>();

    public static UserDTO from(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword("********");
        userDTO.setAdsDTO(user.getAdvertisements().stream().map(AdDTO::from).collect(Collectors.toSet()));
        return userDTO;

    }

    public void setNew_password(String newPassword) {
    }
}
