package dev.boscolo.mktsales.model.dto;

import dev.boscolo.mktsales.model.entities.User;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String email;
    private String password;

    /*public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }*/

    public User toEntity(){
        return MapperUtil.converte(this, User.class);
    }

}