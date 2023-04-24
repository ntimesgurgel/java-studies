package br.com.alura.springdatajpa.services;

import br.com.alura.springdatajpa.orm.Role;
import br.com.alura.springdatajpa.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Scanner;

@Service
public class CrudRoleService {

    private Boolean system = true;
    private  final RoleRepository roleRepository;

    public CrudRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void init(Scanner scanner){

        while(system){
            System.out.println("Which role action do you wish to execute?");
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
        System.out.println("Role Description");
        String roleDescription = scanner.next();
        Role role = new Role();
        role.setRole(roleDescription);
        roleRepository.save(role);
        System.out.println("Role Description saved");
    }

    private void update(Scanner scanner){
        System.out.println("Update Role");
        System.out.println("Id");
        Long id = scanner.nextLong();
        System.out.println("Role Description");
        String description = scanner.next();

        Role role = new Role();
        role.setId(id);
        role.setRole(description);
        roleRepository.save(role);

        System.out.println("Updated Role");
    }

    private void read(){
        System.out.println("Reading roles");
        Iterable<Role> roles = roleRepository.findAll();
        roles.forEach(System.out::println);
    }

    private void delete(Scanner scanner){
        System.out.println("Delete role");
        System.out.println("Inform ID");
        Long id = scanner.nextLong();
        roleRepository.deleteById(id);
        System.out.println("Role deleted");
    }

}
