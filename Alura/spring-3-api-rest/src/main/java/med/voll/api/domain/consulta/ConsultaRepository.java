package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    List<Consulta> existsConsultaByPacienteAndDataBetween(Paciente paciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    Optional<Consulta> findConsultaByDataAndMedico(LocalDateTime data, Medico medico);
}
