package dev.boscolo.mktsales.feignclients;

import dev.boscolo.mktsales.model.dto.UserGetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "mkt-user", path = "/users", url = "http://localhost:8081")
public interface UserFeignClient {

    @GetMapping(value = "/email")
    UserGetDTO findByEmail(@RequestParam String email);
}
