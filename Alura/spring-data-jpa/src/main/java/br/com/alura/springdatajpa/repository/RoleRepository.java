package br.com.alura.springdatajpa.repository;

import br.com.alura.springdatajpa.orm.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
