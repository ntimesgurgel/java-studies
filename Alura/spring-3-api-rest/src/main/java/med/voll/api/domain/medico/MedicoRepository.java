package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
    @Query(
            """
            SELECT M FROM medico M
            
            WHERE 
            M.ativo = true AND 
            M.especialidade = :especialidade AND
            M.id NOT IN(
                SELECT C.medico FROM consulta C
                WHERE 
                
                C.data = :data
                AND
                C.motivoCancelamentoConsulta IS NULL
            )
            ORDER BY RAND()
            LIMIT 1
            """
    )
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
}
