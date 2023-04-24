package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.agendamento.DadosAgendamentoConsulta;
public interface ValidadorAgendamentoConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
