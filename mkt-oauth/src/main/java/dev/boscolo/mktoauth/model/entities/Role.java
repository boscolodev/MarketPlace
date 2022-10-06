package dev.boscolo.mktoauth.model.entities;

import dev.boscolo.mktoauth.model.dto.RoleDTO;
import dev.boscolo.mktoauth.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;

    @Override
    public String getAuthority(){
        return authority;
    }

    public RoleDTO toDTO(){
        return MapperUtil.converte(this, RoleDTO.class);
    }

    public List<RoleDTO> toDtoList(List<Role> userList){
        return userList.stream().map(Role::toDTO).collect(Collectors.toList());
    }
}

