package br.com.alura.springdatajpa.services;

import br.com.alura.springdatajpa.orm.Employee;
import br.com.alura.springdatajpa.orm.WorkUnit;
import br.com.alura.springdatajpa.repository.WorkUnitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CrudWorkUnitService {

    private Boolean system = true;
    private  final WorkUnitRepository workUnitRepository;

    public CrudWorkUnitService(WorkUnitRepository workUnitRepository) {
        this.workUnitRepository = workUnitRepository;
    }

    public void init(Scanner scanner){

        while(system){
            System.out.println("Which work unit action do you wish to execute?");
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
                    this.read();
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
        WorkUnit workUnit = new WorkUnit();
        System.out.println("Insert work unit info: ");
        this.insertInfo(workUnit, scanner);
        System.out.println("Work Unit saved");
    }

    private void update(Scanner scanner){
        WorkUnit workUnit = new WorkUnit();

        System.out.println("Inform Work Unit ID");
        Long id = scanner.nextLong();
        workUnit.setId(id);

        this.insertInfo(workUnit, scanner);

        System.out.println("Work Unit updated");
    }

    private void read(){
        System.out.println("Reading roles");
        Iterable<WorkUnit> units = workUnitRepository.findAll();
        units.forEach(System.out::println);
    }

    private void delete(Scanner scanner){
        System.out.println("Delete role");
        System.out.println("Inform ID");
        Long id = scanner.nextLong();
        workUnitRepository.deleteById(id);
        System.out.println("Role deleted");
    }

    private void insertInfo(WorkUnit workUnit, Scanner scanner){
        System.out.println("Inform the Work Unit Address");
        String address = scanner.next();
        List<Employee> employeeList = new ArrayList<>();

        while(true){

            System.out.println("Inform the Employee's ID, insert nothing to skip:");
            if(scanner.next() == null || scanner.next().equals("0")){
                break;
            }
            Long employeeID = scanner.nextLong();
            Employee employee = new Employee();
            employee.setId(employeeID);
            employeeList.add(employee);
        }

        workUnit.setAddress(address);
        workUnit.setEmployeeList(employeeList);
        workUnitRepository.save(workUnit);
    }
}
