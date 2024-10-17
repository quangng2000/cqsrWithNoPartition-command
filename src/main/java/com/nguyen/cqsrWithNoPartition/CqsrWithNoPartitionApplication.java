package com.nguyen.cqsrWithNoPartition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CqsrWithNoPartitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqsrWithNoPartitionApplication.class, args);
	}

}
