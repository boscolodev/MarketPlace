package dev.boscolo.mktuser.model.entities;

import dev.boscolo.mktuser.model.dto.UserGetDTO;
import dev.boscolo.mktuser.model.dto.UserInsertDTO;
import dev.boscolo.mktuser.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    @Id
    //@SequenceGenerator(name = "ID_GENERATOR", sequenceName ="ID_SEQ")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String password;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> authorities = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public UserGetDTO toDTO() {
        return MapperUtil.converte(this, UserGetDTO.class);
    }

    public UserInsertDTO toInsertDTO() {
        return MapperUtil.converte(this, UserInsertDTO.class);
    }


    public List<UserGetDTO> toDtoList(List<User> userList) {
        return userList.stream().map(User::toDTO).collect(Collectors.toList());
    }

    public Page<UserGetDTO> toDtoPage(Page<User> userPage) {
        return (Page<UserGetDTO>) userPage.stream().map(User::toDTO);
    }

}
