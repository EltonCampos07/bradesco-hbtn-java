public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public int getSaudeAtual() {
        return this.saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        status = this.saudeAtual > 0 ? "vivo" : "morto";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano) {
        var saudeAtualizada = saudeAtual - quantidadeDeDano;
        setSaudeAtual(saudeAtualizada >= 0 ? saudeAtualizada : 0);
    }

    public void receberCura(int quantidadeDeCura) {
        var quantidadeCuraRecebida = saudeAtual + quantidadeDeCura;
        setSaudeAtual(this.saudeAtual = quantidadeCuraRecebida <= 100 ? quantidadeCuraRecebida : 100);
    }

    public String getStatus() {
        return this.status;
    }
}
