package application;

import domain.Cliente;
import domain.Pedido;
import infrastructure.PedidoRepository;
import domain.Produto;

public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(Cliente cliente) {
        var pedido = new Pedido(cliente);
        pedidoRepository.salvar(pedido);
        return pedido;
    }

    public void adicionarProduto(String pedidoId, Produto produto) {
        var pedido = pedidoRepository.buscarPorId(pedidoId);
        pedido.adicionarProduto(produto);
    }

    public void pagarPedido(String pedidoId) {
        var pedido = pedidoRepository.buscarPorId(pedidoId);
        pedido.pagar();
    }

    public void cancelarPedido(String pedidoId) {
        var pedido = pedidoRepository.buscarPorId(pedidoId);
        pedido.cancelar();
    }
}
