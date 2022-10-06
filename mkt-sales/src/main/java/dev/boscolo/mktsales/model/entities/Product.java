package dev.boscolo.mktsales.model.entities;

import dev.boscolo.mktsales.model.dto.ProductGetDTO;
import dev.boscolo.mktsales.model.dto.ProductInsertDTO;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private String description;
    private Double price;
    private String status;

    public ProductGetDTO toDTO() {
        return MapperUtil.converte(this, ProductGetDTO.class);
    }

    public ProductInsertDTO toInsertDTO() {
        return MapperUtil.converte(this, ProductInsertDTO.class);
    }


    public List<ProductGetDTO> toDtoList(List<Product> userList) {
        return userList.stream().map(Product::toDTO).collect(Collectors.toList());
    }
/*
    public Page<ProductGetDTO> toDtoPage(Page<Product> userPage) {
        return (Page<ProductGetDTO>) userPage.stream().map(Product::toDTO);
    }*/

}
