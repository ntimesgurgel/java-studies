package br.com.alura.springdatajpa.specification;

import br.com.alura.springdatajpa.orm.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class EmployeeSpecification {
    public static Specification<Employee> name(String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),"%" + name + "%");
    };

    public static Specification<Employee> address(String address){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("address"),"%" + address + "%");
    };

    public static Specification<Employee> salary(Double salary){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salary"),salary);
    };

    public static Specification<Employee> hiringDate(LocalDate hiringDate){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("hiringDate"),hiringDate);
    };
}
