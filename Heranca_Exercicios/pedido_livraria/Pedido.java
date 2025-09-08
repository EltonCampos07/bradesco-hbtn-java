import java.util.Arrays;
import java.util.Objects;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public void setItens(ItemPedido[] itens) {
        this.itens = itens;
    }

    public double calcularTotal() {
        return Arrays.stream(itens)
                .map(item -> {
                    var valorProduto = item.getQuantidade() * item.getProduto().obterPrecoLiquido();
                    var desconto = valorProduto * Objects.requireNonNullElse((percentualDesconto / 100), 0.00);
                    return valorProduto - desconto;
                })
                .reduce(0.0, Double::sum);
    }
}
