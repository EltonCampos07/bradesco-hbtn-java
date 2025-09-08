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
                .map(item ->  calcularValorProduto(item) - calcularDesconto(calcularValorProduto(item)))
                .reduce(0.0, Double::sum);
    }

    private double calcularTotalSemDesconto() {
        return Arrays.stream(itens)
                .map(item -> calcularValorProduto(item))
                .reduce(0.0, Double::sum);
    }

    private double calcularValorProduto(ItemPedido item) {
        return item.getQuantidade() * item.getProduto().obterPrecoLiquido();
    }

    private Double calcularDesconto(double valorProduto) {
        return valorProduto * Objects.requireNonNullElse((percentualDesconto / 100), 0.00);
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        Arrays.stream(itens)
                .map(item -> String.format(
                        "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f",
                        item.getProduto().getClass().getSimpleName(),
                        item.getProduto().getTitulo(),
                        item.getProduto().obterPrecoLiquido(),
                        item.getQuantidade(),
                        this.calcularValorProduto(item)))
                .forEach(System.out::println);

        var totalPedido = this.calcularTotalSemDesconto();

        System.out.println("----------------------------");
        System.out.println(String.format("DESCONTO: %.2f", this.calcularDesconto(totalPedido)));
        System.out.println(String.format("TOTAL PRODUTOS: %.2f", totalPedido));
        System.out.println("----------------------------");
        System.out.println(String.format("TOTAL PEDIDO: %.2f", this.calcularTotal()));
        System.out.println("----------------------------");
    }
}
