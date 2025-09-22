import java.util.Comparator;
import java.util.List;

public class Consulta {
    
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream()
            .filter(produto -> produto.getCategoria().equals(CategoriaProduto.LIVRO))
            .toList();
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
            .sorted(Comparator.comparing(Produto::getPreco).reversed())
            .findFirst()
            .get();
    }
}
