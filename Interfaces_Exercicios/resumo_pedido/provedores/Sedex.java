package provedores;

public class Sedex implements ProvedorFrete{

    private static final Double PERCENTUAL_SER_PAGO_PESO_ACIMA_1KG = 0.1;
    private static final Double PERCENTUAL_SER_PAGO_PESO_ATE_1KG = 0.05;

    @Override
    public Frete calcularFrete(double valor, double peso) {
        var valorFrete = peso > 1000
                ? valor * PERCENTUAL_SER_PAGO_PESO_ACIMA_1KG
                : valor * PERCENTUAL_SER_PAGO_PESO_ATE_1KG;
        return new Frete(valorFrete, TipoProvedorFrete.SEDEX);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}
