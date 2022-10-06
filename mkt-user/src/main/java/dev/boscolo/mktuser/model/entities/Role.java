package dev.boscolo.mktuser.model.entities;

import dev.boscolo.mktuser.model.dto.RoleDTO;
import dev.boscolo.mktuser.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    //@SequenceGenerator(name = "ID_GENERATOR", sequenceName ="ID_SEQ")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = Instant.now();
    }

    public RoleDTO toDTO(){
        return MapperUtil.converte(this, RoleDTO.class);
    }
    public List<RoleDTO> toDtoList(List<Role> userList){
        return userList.stream().map(Role::toDTO).collect(Collectors.toList());
    }
}
