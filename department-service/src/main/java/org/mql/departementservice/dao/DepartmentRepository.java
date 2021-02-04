package org.mql.departementservice.dao;

import org.mql.departementservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
