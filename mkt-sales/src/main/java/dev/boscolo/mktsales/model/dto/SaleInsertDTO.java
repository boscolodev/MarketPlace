package dev.boscolo.mktsales.model.dto;

import dev.boscolo.mktsales.model.entities.Sale;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleInsertDTO {

    private Long id;
    private String email;
    private Long quantity;

    public Sale toEntity() {
        return MapperUtil.converte(this, Sale.class);
    }


}
