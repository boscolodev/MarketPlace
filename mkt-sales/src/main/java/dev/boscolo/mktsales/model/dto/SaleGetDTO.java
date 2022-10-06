package dev.boscolo.mktsales.model.dto;

import dev.boscolo.mktsales.model.entities.Sale;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleGetDTO {

    private Long id;
    private Long clientId;
    private String clientName;
    private String clientEmail;
    private Long productId;
    private String pruductName;
    private Long quantity;
    private Double productPrice;
    private String status;

    public Sale toEntity() {
        return MapperUtil.converte(this, Sale.class);
    }


}
