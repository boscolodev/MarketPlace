package dev.boscolo.mktsales.model.dto;

import dev.boscolo.mktsales.model.entities.Product;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String status;

    public Product toEntity(){
        return MapperUtil.converte(this, Product.class);
    }

}
