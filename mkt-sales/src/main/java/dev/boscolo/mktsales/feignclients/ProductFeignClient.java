package dev.boscolo.mktsales.feignclients;


import dev.boscolo.mktsales.model.dto.ProductGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "mkt-product", path = "/products",url = "http://localhost:8082")
public interface ProductFeignClient {

    @GetMapping(consumes = "application/json", value = "/{id}")
    ProductGetDTO findById(@PathVariable Long id);


}
