package dev.boscolo.mktoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableFeignClients
@SpringBootApplication
public class MktoauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MktoauthApplication.class, args);
	}

}
