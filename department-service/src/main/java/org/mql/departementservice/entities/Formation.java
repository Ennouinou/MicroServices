package org.mql.departementservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Formation {
    private Long id;
    private String name;
    private Department department;
    private Long department_id;
}
