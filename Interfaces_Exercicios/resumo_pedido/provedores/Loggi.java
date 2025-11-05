package provedores;

public class Loggi implements ProvedorFrete{

    private static final Double PERCENTUAL_SER_PAGO_PESO_ACIMA_5KG = 0.12;
    private static final Double PERCENTUAL_SER_PAGO_PESO_ATE_5KG = 0.04;

    @Override
    public Frete calcularFrete(double valor, double peso) {
        var valorFrete = peso > 5000
                ? valor * PERCENTUAL_SER_PAGO_PESO_ACIMA_5KG
                : valor * PERCENTUAL_SER_PAGO_PESO_ATE_5KG;
        return new Frete(valorFrete, TipoProvedorFrete.LOGGI);
    }
}
