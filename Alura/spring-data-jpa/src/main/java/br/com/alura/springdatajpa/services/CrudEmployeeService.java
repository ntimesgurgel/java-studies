package br.com.alura.springdatajpa.services;

import br.com.alura.springdatajpa.orm.Employee;
import br.com.alura.springdatajpa.orm.Role;
import br.com.alura.springdatajpa.orm.WorkUnit;
import br.com.alura.springdatajpa.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CrudEmployeeService {

    private Boolean system = true;
    private  final EmployeeRepository employeeRepository;

    public CrudEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void init(Scanner scanner){

        while(system){
            System.out.println("Which action do you wish to execute in the employee database?");
            System.out.println("0 - Logout");
            System.out.println("1 - Create");
            System.out.println("2 - Read");
            System.out.println("3 - Update");
            System.out.println("4 - Delete");

            int action = scanner.nextInt();

            switch (action){
                case 1->{
                    this.create(scanner);
                    break;
                }
                case 2->{
                    this.read(scanner);
                    break;
                }
                case 3->{
                    this.update(scanner);
                    break;
                }
                case 4->{
                    this.delete(scanner);
                    break;
                }
                default -> {
                    system = false;
                    break;
                }
            }

        }

        this.create(scanner);
    }

    private void create(Scanner scanner){
        System.out.println("Insert employee info");

        Employee employee = new Employee();
        this.insertInfo(employee, scanner);

        System.out.println("Employee saved");
    }

    private void update(Scanner scanner){
        System.out.println("Update Employee");

        System.out.println("Id");
        Long id = scanner.nextLong();

        Employee employee = new Employee();
        employee.setId(id);

        this.insertInfo(employee, scanner);

        System.out.println("Updated Role");
    }

    private void read(Scanner scanner){

        System.out.println("Which page do you wish to visualize?");
        Integer page = scanner.nextInt();

        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "name"));

        System.out.println("Finding employees");
        Page<Employee> names = employeeRepository.findAll(pageable);

        System.out.println(names);
        System.out.println("Current page: " + names.getNumber());
        System.out.println("Total employees in query: " + names.getTotalElements());
        names.forEach(System.out::println);
    }

    private void delete(Scanner scanner){
        System.out.println("Delete employee");
        System.out.println("Inform ID");
        Long id = scanner.nextLong();
        employeeRepository.deleteById(id);
        System.out.println("Employee deleted");
    }

    private void insertInfo(Employee employee, Scanner scanner){
        System.out.println("Employee Name");
        String employeeName = scanner.next();

        System.out.println("Employee Address");
        String employeeAddress = scanner.next();

        System.out.println("Employee Salary");
        Double employeeSalary = scanner.nextDouble();

        System.out.println("Employee Hiring Date");
        LocalDate employeeHiringDate = LocalDate.parse(scanner.next());

        System.out.println("Employee Role");
        Role employeeRole = new Role();
        employeeRole.setRole(scanner.next());

        System.out.println("Employee Work Units");
        List<WorkUnit> employeeWorkUnits = new ArrayList<WorkUnit>();
        System.out.println("Stop inserting working units passing 0 or nothing");

        while(true){
            if(scanner.next() == null || scanner.next().equals("0")){
                break;
            }
            String employeeWorkUnit = scanner.next();
            WorkUnit workUnit = new WorkUnit();
            workUnit.setAddress(employeeWorkUnit);
            employeeWorkUnits.add(workUnit);
        }

        employee.setName(employeeName);
        employee.setAddress(employeeAddress);
        employee.setSalary(employeeSalary);
        employee.setHiringDate(employeeHiringDate);
        employee.setRole(employeeRole);
        employee.setWorkUnitList(employeeWorkUnits);

        employeeRepository.save(employee);
    }

}
