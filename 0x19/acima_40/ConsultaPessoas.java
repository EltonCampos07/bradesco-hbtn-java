import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Pessoa::getCargo));
    }

    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> listaPessoa) {
        return listaPessoa.stream()
                .collect(Collectors.groupingBy(
                    Pessoa::getCargo,
                    Collectors.filtering(
                        pessoa -> pessoa.getIdade() > 40,
                        Collectors.toList()
                    )
                ));
    }
}
