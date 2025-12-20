import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Digite as linhas de texto (digite 'sair' para finalizar):");

            String line;
            while (true) {
                line = scanner.nextLine();

                if (line.equalsIgnoreCase("sair")) {
                    break;
                }

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Arquivo '" + fileName + "' foi criado e seu conteúdo foi salvo com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao criar ou escrever no arquivo: " + e.getMessage());
        }


        scanner.close();
    }
}
