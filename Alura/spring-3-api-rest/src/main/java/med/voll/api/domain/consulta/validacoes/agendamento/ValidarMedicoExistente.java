package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.agendamento.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoExistente implements ValidadorAgendamentoConsulta{
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        boolean idMedicoNulo = dados.idMedico() == null;
        boolean idMedicoExiste = medicoRepository.existsById(dados.idPaciente());

        if(!idMedicoNulo && !idMedicoExiste){
            throw new ValidacaoException("Id do médico informado não existe");
        }
    }
}
