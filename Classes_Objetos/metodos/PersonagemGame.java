public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return this.saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano) {
        var saudeAtualizada = saudeAtual - quantidadeDeDano;
        this.saudeAtual = saudeAtualizada >= 0 ? saudeAtualizada : 0;
    }

    public void receberCura(int quantidadeDeCura) {
        var quantidadeCuraRecebida = saudeAtual + quantidadeDeCura;
        this.saudeAtual = quantidadeCuraRecebida <= 100 ? quantidadeCuraRecebida : 100;
    }
}
