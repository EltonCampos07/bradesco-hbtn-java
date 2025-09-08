public class FolhaPagamento {
    
    static double calcularLiquido(Funcionario funcionario, CalculadorDeSalario calculador) {
        return calculador.calcular(funcionario.getSalario());
    }
}
