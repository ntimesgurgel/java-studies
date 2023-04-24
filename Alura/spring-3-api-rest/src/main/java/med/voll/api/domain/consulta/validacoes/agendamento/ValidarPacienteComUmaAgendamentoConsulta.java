package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.agendamento.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteComUmaAgendamentoConsulta implements ValidadorAgendamentoConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());

        var dataInicio = dados.data().toLocalDate().atTime(7,0);
        var dataFim = dados.data().toLocalDate().atTime(18,0);

        var consultasDoPaciente = consultaRepository.existsConsultaByPacienteAndDataBetween(paciente, dataInicio, dataFim);

        if(consultasDoPaciente.size() != 1){
            throw new ValidacaoException("O paciente já possui mais de uma consulta marcada nesse dia");
        }
    }
}
