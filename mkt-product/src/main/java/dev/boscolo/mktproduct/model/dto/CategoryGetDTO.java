package dev.boscolo.mktproduct.model.dto;

import dev.boscolo.mktproduct.model.entities.Category;
import dev.boscolo.mktproduct.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryGetDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Category toEntity(){
        return MapperUtil.converte(this, Category.class);
    }

}
