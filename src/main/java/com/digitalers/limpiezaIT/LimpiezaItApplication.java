package com.digitalers.limpiezaIT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication( exclude = { SecurityAutoConfiguration.class } )
public class LimpiezaItApplication {

	public static void main(String[] args) { SpringApplication.run(LimpiezaItApplication.class, args); }

}
