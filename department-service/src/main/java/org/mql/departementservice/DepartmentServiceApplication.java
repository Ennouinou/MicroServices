package org.mql.departementservice;

import org.mql.departementservice.dao.DepartmentRepository;
import org.mql.departementservice.entities.Department;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(DepartmentRepository departmentRepository){
        return  args -> {
          departmentRepository.save(new Department(null,"Informatique"));
          departmentRepository.save(new Department(null,"Chimie"));
          departmentRepository.save(new Department(null,"Geologie"));
          departmentRepository.findAll().forEach(System.out::println);
        };
    }
}
