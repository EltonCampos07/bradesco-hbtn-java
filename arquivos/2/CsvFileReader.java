import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (isFirstLine) {
                    System.out.println("Funcionário: " + data[0]);
                    System.out.println("Idade: " + data[1]);
                    System.out.println("Departamento: " + data[2]);
                    System.out.println("Salarial: " + data[3]);
                    System.out.println("------------------------");
                    isFirstLine = false;
                } else {
                    System.out.println("Funcionário: " + data[0]);
                    System.out.println("Idade: " + data[1]);
                    System.out.println("Departamento: " + data[2]);
                    System.out.println("Salarial: " + data[3]);
                    System.out.println("------------------------");
                }
            }

            System.out.println("Leitura do arquivo concluída.");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

