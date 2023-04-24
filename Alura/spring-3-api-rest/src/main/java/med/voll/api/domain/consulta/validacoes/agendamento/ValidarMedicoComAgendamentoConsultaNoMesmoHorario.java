package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.agendamento.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoComAgendamentoConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var medico = medicoRepository.getReferenceById(dados.idMedico());
        var consulta = consultaRepository.findConsultaByDataAndMedico(dados.data(), medico);

        if(!consulta.isEmpty()){
            throw new ValidacaoException("Médico já possui atendimento no horário marcado");
        }
    }
}
