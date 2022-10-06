package dev.boscolo.mktproduct.model.entities;

import dev.boscolo.mktproduct.model.dto.ProductGetDTO;
import dev.boscolo.mktproduct.model.dto.ProductInsertDTO;
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
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    //@SequenceGenerator(name = "ID_GENERATOR", sequenceName ="ID_SEQ")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String status;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public ProductGetDTO toDTO() {
        return MapperUtil.converte(this, ProductGetDTO.class);
    }

    public ProductInsertDTO toInsertDTO() {
        return MapperUtil.converte(this, ProductInsertDTO.class);
    }


    public List<ProductGetDTO> toDtoList(List<Product> userList) {
        return userList.stream().map(Product::toDTO).collect(Collectors.toList());
    }

    public Page<ProductGetDTO> toDtoPage(Page<Product> userPage) {
        return (Page<ProductGetDTO>) userPage.stream().map(Product::toDTO);
    }

}
