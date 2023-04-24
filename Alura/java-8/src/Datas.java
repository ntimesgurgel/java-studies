import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

        int anos = hoje.getYear() - olimpiadasRio.getYear();

        Period periodo = Period.between(hoje, olimpiadasRio);
        System.out.println(periodo.getYears());

        LocalDate daquiVinteDias = hoje.plusDays(20);

        System.out.println(daquiVinteDias);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String valorFormatado = daquiVinteDias.format(formatador);
        System.out.println(valorFormatado);

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatador));
    }
}
