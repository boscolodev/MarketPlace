package dev.boscolo.mktsales.model.entities;

import dev.boscolo.mktsales.model.dto.SaleGetDTO;
import dev.boscolo.mktsales.utils.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    private Long id;
    private Long clientId;
    private String clientName;
    private String clientEmail;
    private Long productId;
    private String pruductName;
    private Long quantity;
    private Double productPrice;
    private String status;

    public SaleGetDTO toDTO() {
        return MapperUtil.converte(this, SaleGetDTO.class);
    }

    public List<SaleGetDTO> toDtoList(List<Sale> userList) {
        return userList.stream().map(Sale::toDTO).collect(Collectors.toList());
    }

}
