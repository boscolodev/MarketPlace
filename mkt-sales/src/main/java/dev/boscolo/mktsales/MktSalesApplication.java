package dev.boscolo.mktsales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MktSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MktSalesApplication.class, args);
	}

}
