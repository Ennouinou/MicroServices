package org.mql.formationservice;

import org.mql.formationservice.dao.FormationRepository;
import org.mql.formationservice.entities.Department;
import org.mql.formationservice.entities.Formation;
import org.mql.formationservice.feign.DepartmentRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FormationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormationServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(FormationRepository formationRepository , DepartmentRestClient departmentRestClient){
        return args -> {
            System.out.println(departmentRestClient);
            Department department = departmentRestClient.getDepartmentById(1L);
            System.out.println(department);
            formationRepository.save(new Formation(null,"MQL",department,1L));
            formationRepository.save(new Formation(null,"SIGL",department,1L));
            formationRepository.save(new Formation(null,"WISD",department,1L));
            formationRepository.findAll().forEach(System.out::println);
        };

    }
}
