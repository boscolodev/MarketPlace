package dev.boscolo.mktuser.dto;

import dev.boscolo.mktuser.entities.User;
import dev.boscolo.mktuser.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Set<RoleDTO> authorities = new HashSet<>();

    public User toEntity(){
        return MapperUtil.converte(this, User.class);
    }

}
