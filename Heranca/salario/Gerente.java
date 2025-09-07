package Heranca.salario;

public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        return departamento.alcancouMeta() 
            ? ((super.getSalarioFixo() * 0.2) + (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01)
            : 0;
    }
    
}
