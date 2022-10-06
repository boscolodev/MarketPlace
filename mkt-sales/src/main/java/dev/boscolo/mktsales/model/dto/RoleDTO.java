package dev.boscolo.mktsales.model.dto;

import dev.boscolo.mktsales.model.entities.Role;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;

    public Role toEntity(){
        return MapperUtil.converte(this, Role.class);
    }
}
