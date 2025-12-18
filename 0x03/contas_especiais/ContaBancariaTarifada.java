public class ContaBancariaTarifada extends ContaBancariaBasica {

    private int quantidadeTransacoes;
    private static final double TARIFA_POR_TRANSACAO = 0.10;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        // aplicar tarifa por transação
        ajustarSaldo(-TARIFA_POR_TRANSACAO);
        this.quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        // aplicar tarifa por transação
        ajustarSaldo(-TARIFA_POR_TRANSACAO);
        this.quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}
