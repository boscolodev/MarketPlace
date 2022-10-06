package dev.boscolo.mktproduct.model.entities;

import dev.boscolo.mktproduct.model.dto.CategoryGetDTO;
import dev.boscolo.mktproduct.model.dto.CategoryInsertDTO;
import dev.boscolo.mktproduct.utils.MapperUtil;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    //@SequenceGenerator(name = "ID_GENERATOR", sequenceName ="ID_SEQ")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public CategoryGetDTO toDTO() {
        return MapperUtil.converte(this, CategoryGetDTO.class);
    }

    public CategoryInsertDTO toInsertDTO() {
        return MapperUtil.converte(this, CategoryInsertDTO.class);
    }


    public List<CategoryGetDTO> toDtoList(List<Category> userList) {
        return userList.stream().map(Category::toDTO).collect(Collectors.toList());
    }

    public Page<CategoryGetDTO> toDtoPage(Page<Category> userPage) {
        return (Page<CategoryGetDTO>) userPage.stream().map(Category::toDTO);
    }

}
