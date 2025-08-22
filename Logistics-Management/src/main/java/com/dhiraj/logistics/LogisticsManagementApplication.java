package com.dhiraj.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "com.dhiraj.logistics.repository")
public class LogisticsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsManagementApplication.class, args);
	}

}
