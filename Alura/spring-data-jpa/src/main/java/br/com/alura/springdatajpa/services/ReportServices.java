package br.com.alura.springdatajpa.services;

import br.com.alura.springdatajpa.orm.Employee;
import br.com.alura.springdatajpa.orm.EmployeeProjection;
import br.com.alura.springdatajpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class ReportServices {
    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final EmployeeRepository employeeRepository;

    public ReportServices(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public void init(Scanner scanner) {

        while (system) {
            System.out.println("Which role action do you wish to execute?");
            System.out.println("0 - Logout");
            System.out.println("1 - Find Employee by Name");
            System.out.println("2 - Find Employee by Name, Hiring Date and Salary greater than");
            System.out.println("3 - Find Employee by Hiring Date greater than");

            int action = scanner.nextInt();

            switch (action) {
                case 1 -> {
                    findEmployeeByName(scanner);
                    break;
                }
                case 2 ->{
                    findEmployeeByNameDateAndSalaryGreaterThan(scanner);
                    break;
                }
                case 3->{
                    findEmployeeByHiringDate(scanner);
                    break;
                }
                default -> {
                    system = false;
                    break;
                }
            }
        }
    }

    private void findEmployeeByName(Scanner scanner){
        System.out.println("Which name do you wish to search?");
        String name = scanner.next();
        List<Employee> employeeList = employeeRepository.findByName(name);
        employeeList.forEach(System.out::println);
    }

    private void findEmployeeByNameDateAndSalaryGreaterThan(Scanner scanner){
        System.out.println("Which name do you wish to search?");
        String name = scanner.next();

        System.out.println("Which hiring date do you wish to search?");
        String date = scanner.next();
        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println("Which salary do you wish to search?");
        Double salary = scanner.nextDouble();

        List<Employee> employeeList = employeeRepository.findNameHiringDateSalaryGreater(name, salary, localDate);
        employeeList.forEach(System.out::println);
    }

    private void findEmployeeByHiringDate(Scanner scanner){
        System.out.println("Which hiring date do you wish to search?");
        String date = scanner.next();
        LocalDate localDate = LocalDate.parse(date, formatter);

        List<Employee> employeeList = employeeRepository.findHiringDateGreater(localDate);
        employeeList.forEach(System.out::println);
    }

    private void findEmployeeBySalaryOrderDesc(){
        List<EmployeeProjection> employeeList = employeeRepository.findEmployeeSalary();
        employeeList.forEach(e-> System.out.println(
                "Employee [id: " + e.getId() +
                        " | name: " + e.getName() +
                        " | salary: " + e.getSalary() + "]"
        ));
    }
}