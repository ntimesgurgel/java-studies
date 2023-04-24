package br.com.alura.springdatajpa.repository;

import br.com.alura.springdatajpa.orm.WorkUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkUnitRepository extends CrudRepository<WorkUnit, Long> {
}
