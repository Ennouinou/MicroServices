package org.mql.formationservice.feign;

import org.mql.formationservice.entities.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentRestClient {
    @GetMapping("/departments/{id}")
    Department getDepartmentById(@PathVariable(name = "id") Long id);
}
