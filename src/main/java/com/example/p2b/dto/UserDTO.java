package com.example.p2b.dto;

import com.example.p2b.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String userpassword;
    private String usernickname;
    private String useremail;
    private User user;
    private User.Role role;

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setUserpassword(user.getUserPassword());
        userDTO.setUsernickname(user.getUserNickName());
        userDTO.setUseremail(user.getUserEmail());
        userDTO.setUser(user);
        return userDTO;
    }
}
