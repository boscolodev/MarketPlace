package dev.boscolo.mktgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MktGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MktGatewayApplication.class, args);
	}

}
