package dev.boscolo.mktsales.model.entities;

import dev.boscolo.mktsales.model.dto.UserGetDTO;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    private Set<Role> authorities = new HashSet<>();

    public UserGetDTO toDTO() {
        return MapperUtil.converte(this, UserGetDTO.class);
    }

    public List<UserGetDTO> toDtoList(List<User> userList) {
        return userList.stream().map(User::toDTO).collect(Collectors.toList());
    }

}
