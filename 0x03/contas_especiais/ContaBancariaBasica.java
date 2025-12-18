public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0.0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (valor > this.saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        this.saldo -= valor;
    }

    public double calcularTarifaMensal() {
        if (this.saldo <= 0) {
            return 0.0;
        }
        double dezPorcento = this.saldo * 0.10;
        return Math.min(10.0, dezPorcento);
    }

    public double calcularJurosMensal() {
        return this.saldo <= 0 ? 0.0 : this.saldo * (this.taxaJurosAnual / 100.0) / 12.0;
    }

    public void aplicarAtualizacaoMensal() {
        double saldoAntes = this.saldo;
        double juros = saldoAntes <= 0 ? 0.0 : saldoAntes * (this.taxaJurosAnual / 100.0) / 12.0;
        double tarifa = calcularTarifaMensal();
        this.saldo -= tarifa;
        this.saldo += juros;
    }
    
    protected void ajustarSaldo(double delta) {
        this.saldo += delta;
    }
}
