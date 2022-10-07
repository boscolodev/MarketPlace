package dev.boscolo.mktproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MktProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MktProductApplication.class, args);
	}

}
