package com.returncode.apseboot.prefiled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath*:rpc-apse-prefiled.xml" })
@SpringBootApplication
public class ApsePreFiledServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsePreFiledServiceApplication.class, args);
	}

}
