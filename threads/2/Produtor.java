import java.util.Random;

public class Produtor extends Thread {
    private final Fila fila;
    private final String nome;
    private final Random random = new Random();
    private volatile boolean ativo = true;

    public Produtor(Fila fila, String nome) {
        this.fila = fila;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (ativo) {
                int numero = random.nextInt(100) + 1;

                System.out.println(nome + " gerando numero: " + numero);
                fila.adicionar(numero);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " foi interrompido.");
            Thread.currentThread().interrupt();
        }
    }

    public void parar() {
        ativo = false;
        this.interrupt();
    }
}
