package org.mql.formationservice;

import org.mql.formationservice.dao.FormationRepository;
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
            formationRepository.save(new Formation(null,"MQL",departmentRestClient.getDepartmentById(1L),1L));
            formationRepository.save(new Formation(null,"SIGL",departmentRestClient.getDepartmentById(1L),1L));
            formationRepository.save(new Formation(null,"WISD",departmentRestClient.getDepartmentById(1L),1L));
            formationRepository.findAll().forEach(System.out::println);
        };

    }
}
