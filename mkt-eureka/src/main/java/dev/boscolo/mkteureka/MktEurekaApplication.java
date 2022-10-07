package dev.boscolo.mkteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MktEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MktEurekaApplication.class, args);
	}

}
