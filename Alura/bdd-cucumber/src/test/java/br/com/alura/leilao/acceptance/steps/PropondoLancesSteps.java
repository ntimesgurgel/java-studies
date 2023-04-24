package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropondoLancesSteps {
    private Leilao leilao;
    private List<Lance> lances;
    @Before
    public void inicializar_lista_de_lances(){
        this.lances = new ArrayList<Lance>();
        this.leilao = new Leilao("Table XPTO");
    }

    @Quando("propõe ao leilão")
    public void quando_propõe_ao_leilão(){
        this.lances.forEach(lance -> this.leilao.propoe(lance));
    }

    @Quando("propõe vários lances ao leilão")
    public void propõe_vários_lances_ao_leilão() {
        this.lances.forEach(lance-> this.leilao.propoe(lance));
    }

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
        // Write code here that turns the phrase above into concrete actions
        Usuario usuario = new Usuario(nomeUsuario);
        Lance lance = new Lance(usuario, new BigDecimal(valor));
        this.lances.add(lance);
    }

    @Dado("um lance inválido de {double} reais do usuário {string}")
    public void um_lance_invalido_do_usuario(Double valor, String nomeUsuario) {
        // Write code here that turns the phrase above into concrete actions
        Usuario usuario = new Usuario(nomeUsuario);
        Lance lance = new Lance(usuario, new BigDecimal(valor));
        this.lances.add(lance);
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> valores = dataTable.asMaps();
        for(Map<String, String> mapa: valores){
            String valor = mapa.get("valor");
            String usuario = mapa.get("nomeUsuario");

            Lance lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
            this.lances.add(lance);
        }
    }

    @Então("os lances são aceitos")
    public void os_lances_são_aceitos() {
        Assertions.assertEquals(
                2,
                this.leilao.getLances().size()
        );
        Assertions.assertEquals(
                this.lances.get(0).getValor(),
                this.leilao.getLances().get(0).getValor()
        );
        Assertions.assertEquals(
                this.lances.get(1).getValor(),
                this.leilao.getLances().get(1).getValor()
        );
    }

    @Então("o lance é aceito")
    public void entao_o_lance_e_aceito(){
        Assertions.assertEquals(
                1,
                leilao.getLances().size()
        );
        Assertions.assertEquals(
                BigDecimal.TEN, leilao.getLances().get(0).getValor()
        );
    }

    @Então("o lance não é aceito")
    public void o_lance_nao_eh_aceito() {
        Assertions.assertEquals(
            0, this.leilao.getLances().size()
        );
    }

    @Então("o segundo lance não é aceito")
    public void o_segundo_lance_não_é_aceito() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(
                1, this.leilao.getLances().size()
        );
    }


}
