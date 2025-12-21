import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private String nomeArquivo;

    // Construtor
    public Estoque(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.produtos = new ArrayList<>();
        carregarEstoque();
    }

    // Carrega os produtos do arquivo CSV
    private void carregarEstoque() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    int quantidade = Integer.parseInt(dados[2].trim());
                    double preco = Double.parseDouble(dados[3].trim());

                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar dados do arquivo: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }

    // Salva os produtos no arquivo CSV
    private void salvarEstoque() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(nomeArquivo));

            for (Produto produto : produtos) {
                bw.write(produto.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }

    // Adiciona um novo produto
    public void adicionarProduto(String nome, int quantidade, double preco) {
        // Validações
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: Nome do produto não pode ser vazio!");
            return;
        }

        if (quantidade < 0) {
            System.out.println("Erro: Quantidade não pode ser negativa!");
            return;
        }

        if (preco < 0) {
            System.out.println("Erro: Preço não pode ser negativo!");
            return;
        }

        // Gera um novo ID único
        int novoId = 1;
        for (Produto p : produtos) {
            if (p.getId() >= novoId) {
                novoId = p.getId() + 1;
            }
        }

        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarEstoque();
    }

    // Exclui um produto pelo ID
    public void excluirProduto(int id) {
        boolean encontrado = false;

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
                salvarEstoque();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Erro: Produto com ID " + id + " não encontrado!");
        }
    }

    // Exibe todos os produtos
    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    // Atualiza a quantidade de um produto
    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            return;
        }

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                salvarEstoque();
                break;
            }
        }
    }
}

