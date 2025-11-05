package provedores;

public class JadLog implements ProvedorFrete {

    private static final Double PERCENTUAL_SER_PAGO_PESO_ACIMA_2KG = 0.07;
    private static final Double PERCENTUAL_SER_PAGO_PESO_ATE_2KG = 0.045;

    @Override
    public Frete calcularFrete(double valor, double peso) {
        var valorFrete = peso > 2000
                ? valor * PERCENTUAL_SER_PAGO_PESO_ACIMA_2KG
                : valor * PERCENTUAL_SER_PAGO_PESO_ATE_2KG;
        return new Frete(valorFrete, TipoProvedorFrete.JADLOG);
    }
}
