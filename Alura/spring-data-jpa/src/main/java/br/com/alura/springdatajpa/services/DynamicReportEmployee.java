package br.com.alura.springdatajpa.services;

import br.com.alura.springdatajpa.orm.Employee;
import br.com.alura.springdatajpa.repository.EmployeeRepository;
import br.com.alura.springdatajpa.specification.EmployeeSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class DynamicReportEmployee {
    private final EmployeeRepository employeeRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DynamicReportEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void init(Scanner scanner){
        System.out.println("Inform the name:");
        String name = scanner.next();
        if(name.equalsIgnoreCase("NULL")){
            name = null;
        }

        System.out.println("Inform the address:");
        String address = scanner.next();
        if(address.equalsIgnoreCase("NULL")){
            address = null;
        }

        System.out.println("Inform the salary:");
        Double salary = scanner.nextDouble();
        if(salary == 0){
            salary = null;
        }

        System.out.println("Inform the hiring date:");
        String date = scanner.next();
        LocalDate hiringDate;
        if(date.equalsIgnoreCase("NULL")){
            hiringDate = null;
        } else {
            hiringDate = LocalDate.parse(date, formatter);
        }


        List<Employee> employeeList = employeeRepository
                .findAll(
                        Specification.where(
                                EmployeeSpecification.name(name)
                        ).or(
                                EmployeeSpecification.address(address)
                        ).or(
                                EmployeeSpecification.salary(salary)
                        ).or(
                                EmployeeSpecification.hiringDate(hiringDate)
                        )
                );

        employeeList.forEach(System.out::println);
    }

}
