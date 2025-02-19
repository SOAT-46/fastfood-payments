package com.github.soat46.fastfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FastfoodPaymentsApplication {
  public static void main(String[] args) {
    SpringApplication.run(FastfoodPaymentsApplication.class, args);
  }
}
