package med.voll.api.domain.consulta.agendamento;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamentoConsulta motivo
) {
}
