package br.com.alura.springdatajpa.repository;

import br.com.alura.springdatajpa.orm.Employee;
import br.com.alura.springdatajpa.orm.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    List<Employee> findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.name = :name AND e.salary >= :salary AND e.hiringDate = :date")
    List<Employee> findNameHiringDateSalaryGreater(String name, double salary, LocalDate date);

    @Query(value = "SELECT * FROM employees e WHERE e.hiring_date >= :date", nativeQuery = true)
    List<Employee> findHiringDateGreater(LocalDate date);

    @Query(value = "SELECT e.id, e.name, e.salary FROM employees e ORDER BY salary DESC", nativeQuery = true)
    List<EmployeeProjection> findEmployeeSalary();
}
