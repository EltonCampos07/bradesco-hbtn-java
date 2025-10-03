public class Consumidor extends Thread {
    private final Fila fila;
    private final String nome;
    private volatile boolean ativo = true;

    public Consumidor(Fila fila, String nome) {
        this.fila = fila;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (ativo) {
                int numero = fila.retirar();
                System.out.println(nome + " processando numero: " + numero);
                Thread.sleep(500);
                System.out.println(nome + " finalizou processamento do nusmero: " + numero);
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
