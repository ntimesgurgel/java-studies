package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.consulta.agendamento.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoConsulta {

    void validar(DadosCancelamentoConsulta dados);
}
