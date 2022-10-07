package dev.boscolo.mktsales.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.boscolo.mktsales.model.entities.Sale;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleGetDTO {

    @JsonProperty(value ="Sale ID")
    private Long id;
    @JsonProperty(value ="Client ID")
    private Long clientId;
    @JsonProperty(value ="Client")
    private String clientName;
    @JsonProperty(value ="Email")
    private String clientEmail;
    @JsonProperty(value ="Product ID")
    private Long productId;
    @JsonProperty(value ="Product")
    private String pruductName;
    @JsonProperty(value ="Product Quantity")
    private Long quantity;
    @JsonProperty(value ="Product Price")
    private Double productPrice;
    @JsonProperty(value ="Product Amount")
    private Double amount;
    private String status;

    public Sale toEntity() {
        return MapperUtil.converte(this, Sale.class);
    }


}
