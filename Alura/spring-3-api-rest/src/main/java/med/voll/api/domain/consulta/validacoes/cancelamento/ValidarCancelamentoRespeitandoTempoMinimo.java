package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.agendamento.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarCancelamentoRespeitandoTempoMinimo implements ValidadorCancelamentoConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Override
    public void validar(DadosCancelamentoConsulta dados) {

        LocalDateTime dataConsulta = consultaRepository.getReferenceById(dados.idConsulta()).getData();
        LocalDateTime dataCancelamento = LocalDateTime.now();
        Boolean permitido = Duration.between(dataCancelamento, dataConsulta).toHours() > 24;

        if(!permitido){
            throw new ValidacaoException("Não é possível cancelar consultas com menos de 24 horas de antecedência");
        }
    }
}
