package dev.boscolo.mktuser.model.dto;

import dev.boscolo.mktuser.model.entities.User;
import dev.boscolo.mktuser.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public User toEntity(){
        return MapperUtil.converte(this, User.class);
    }

}
