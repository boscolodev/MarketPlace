package dev.boscolo.mktsales.services;

import dev.boscolo.mktsales.feignclients.ProductFeignClient;
import dev.boscolo.mktsales.feignclients.UserFeignClient;
import dev.boscolo.mktsales.model.dto.SaleGetDTO;
import dev.boscolo.mktsales.model.dto.SaleInsertDTO;
import dev.boscolo.mktsales.model.entities.Product;
import dev.boscolo.mktsales.model.entities.Sale;
import dev.boscolo.mktsales.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalesService {

    private final UserFeignClient userFeignClient;
    private final ProductFeignClient productFeignClient;


    public SalesService(UserFeignClient userFeignClient, ProductFeignClient productFeignClient) {
        this.userFeignClient = userFeignClient;
        this.productFeignClient = productFeignClient;
    }


    public SaleGetDTO postSale(SaleInsertDTO dto) {

        User user = userFeignClient.findByEmail(dto.getEmail()).toEntity();
        Product product = productFeignClient.findById(dto.getId()).toEntity();
        Sale sale = new Sale();
        sale.setId(UUID.randomUUID().getLeastSignificantBits());
        sale.setClientEmail(user.getEmail());
        sale.setClientId(user.getId());
        sale.setClientName(user.getName());
        sale.setProductId(product.getId());
        sale.setProductPrice(product.getPrice());
        sale.setPruductName(product.getName());
        sale.setQuantity(dto.getQuantity());

        return sale.toDTO();
    }

}
