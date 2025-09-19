import java.util.List;

public class ConsultaProdutos {
    
    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {
        return produtos.stream()
            .filter(produto -> criterio.testar(produto))
            .toList();
    }
}
