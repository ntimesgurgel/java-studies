package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.agendamento.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteAtivo implements ValidadorAgendamentoConsulta {
    @Autowired
    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = pacienteRepository.getReferenceById(dados.idPaciente()).getAtivo();

        if(!pacienteAtivo){
            throw new ValidacaoException("Paciente não está ativo");
        }
    }
}
