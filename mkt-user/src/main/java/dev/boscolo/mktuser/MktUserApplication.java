package dev.boscolo.mktuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MktUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MktUserApplication.class, args);
	}

}
