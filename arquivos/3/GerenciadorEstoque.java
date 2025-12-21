import java.util.Scanner;
import java.util.InputMismatchException;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque("estoque.csv");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        System.out.print("Digite o nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        System.out.print("Digite o preço: ");
                        double preco = scanner.nextDouble();
                        estoque.adicionarProduto(nome, quantidade, preco);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Entrada inválida! Certifique-se de digitar números válidos.");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Digite o ID do produto a ser excluído: ");
                        int idExcluir = scanner.nextInt();
                        estoque.excluirProduto(idExcluir);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Digite um ID válido!");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("\nEstoque:");
                    estoque.exibirEstoque();
                    break;

                case 4:
                    try {
                        System.out.print("Digite o ID do produto: ");
                        int idAtualizar = scanner.nextInt();
                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Digite valores válidos!");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

