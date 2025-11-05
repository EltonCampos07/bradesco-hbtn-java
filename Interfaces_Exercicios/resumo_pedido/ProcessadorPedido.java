import provedores.Frete;
import provedores.ProvedorFrete;

public class ProcessadorPedido {
    private ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }

    public ProvedorFrete getProvedorFrete() {
        return provedorFrete;
    }

    public void setProvedorFrete(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }

    public void processar(Pedido pedido) {
        Frete frete = provedorFrete.calcularFrete(pedido.getTotal(), pedido.getPeso());
        pedido.setFrete(frete);
    }
}
