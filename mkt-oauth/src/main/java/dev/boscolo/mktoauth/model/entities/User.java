package dev.boscolo.mktoauth.model.entities;

import dev.boscolo.mktoauth.model.dto.UserGetDTO;
import dev.boscolo.mktoauth.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails, Serializable {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
