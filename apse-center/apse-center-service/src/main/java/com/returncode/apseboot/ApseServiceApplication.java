package com.returncode.apseboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath*:rpc-apse-center.xml" })
@SpringBootApplication
public class ApseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApseServiceApplication.class, args);
	}

}
