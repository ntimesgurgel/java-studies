package br.com.alura.springdatajpa;

import br.com.alura.springdatajpa.orm.Role;
import br.com.alura.springdatajpa.repository.RoleRepository;
import br.com.alura.springdatajpa.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Boolean system = true;
	private final CrudRoleService crudRoleService;
	private final CrudEmployeeService crudEmployeeService;
	private final CrudWorkUnitService crudWorkUnitService;
	private final ReportServices reportServices;

	private final DynamicReportEmployee dynamicReportEmployee;

	public SpringDataJpaApplication(
			CrudRoleService crudRoleService,
			CrudEmployeeService crudEmployeeService,
			CrudWorkUnitService crudWorkUnitService,
			ReportServices reportServices,
			DynamicReportEmployee dynamicReportEmployee) {

		this.crudRoleService = crudRoleService;
		this.crudEmployeeService = crudEmployeeService;
		this.crudWorkUnitService = crudWorkUnitService;
		this.reportServices = reportServices;
		this.dynamicReportEmployee = dynamicReportEmployee;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("Which action do you wish to execute?");
			System.out.println("0 - Logout");
			System.out.println("1 - Role");
			System.out.println("2 - Employee");
			System.out.println("3 - Work Unit");
			System.out.println("4 - Reports");
			System.out.println("5 - Dynamic Report");
			int action = scanner.nextInt();
			switch (action) {
				case 1 -> {
					crudRoleService.init(scanner);
					break;
				}
				case 2 -> {
					crudEmployeeService.init(scanner);
					break;
				}
				case 3 -> {
					crudWorkUnitService.init(scanner);
					break;
				}
				case 4 ->{
					reportServices.init(scanner);
					break;
				}
				case 5 ->{
					dynamicReportEmployee.init(scanner);
					break;
				}
				default -> {
					system = false;
					break;
				}
			}
		}
	}
}
