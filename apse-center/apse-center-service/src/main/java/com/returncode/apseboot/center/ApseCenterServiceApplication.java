package com.returncode.apseboot.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath*:rpc-apse-center.xml" })
@SpringBootApplication
public class ApseCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApseCenterServiceApplication.class, args);
	}

}
