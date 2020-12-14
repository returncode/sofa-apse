package com.returncode.apseboot.open;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:rpc-apse-open.xml"})
@SpringBootApplication
public class ApseOpenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApseOpenServiceApplication.class, args);
    }

}
