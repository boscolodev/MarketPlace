package dev.boscolo.mktsales.model.entities;

import dev.boscolo.mktsales.model.dto.CategoryInsertDTO;
import dev.boscolo.mktsales.model.dto.CategoryGetDTO;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private Set<Product> products = new HashSet<>();


    public CategoryGetDTO toDTO() {
        return MapperUtil.converte(this, CategoryGetDTO.class);
    }

    public CategoryInsertDTO toInsertDTO() {
        return MapperUtil.converte(this, CategoryInsertDTO.class);
    }


    public List<CategoryGetDTO> toDtoList(List<Category> userList) {
        return userList.stream().map(Category::toDTO).collect(Collectors.toList());
    }
/*
    public Page<CategoryGetDTO> toDtoPage(Page<Category> userPage) {
        return (Page<CategoryGetDTO>) userPage.stream().map(Category::toDTO);
    }*/

}
