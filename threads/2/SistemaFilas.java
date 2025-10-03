import java.util.ArrayList;
import java.util.List;

public class SistemaFilas {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Filas - Produtores e Consumidores ===\n");

        Fila fila = new Fila(10);

        List<Thread> threads = new ArrayList<>();
        List<Produtor> produtores = new ArrayList<>();
        List<Consumidor> consumidores = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Produtor produtor = new Produtor(fila, "Produtor-" + i);
            produtores.add(produtor);
            threads.add(produtor);
        }

        for (int i = 1; i <= 2; i++) {
            Consumidor consumidor = new Consumidor(fila, "Consumidor-" + i);
            consumidores.add(consumidor);
            threads.add(consumidor);
        }

        System.out.println("Iniciando threads...\n");
        for (Thread thread : threads) {
            thread.start();
        }

        try {
            System.out.println("Sistema executando por 20 segundos...\n");
            Thread.sleep(20000);

            System.out.println("\n=== Encerrando sistema ===");

            for (Produtor produtor : produtores) {
                produtor.parar();
            }
            for (Consumidor consumidor : consumidores) {
                consumidor.parar();
            }

            for (Thread thread : threads) {
                thread.join(1000);
            }

            System.out.println("Tamanho final da fila: " + fila.tamanho());
            System.out.println("Sistema encerrado com sucesso!");

        } catch (InterruptedException e) {
            System.err.println("Erro durante a execucao: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            System.exit(0);
        }
    }
}
