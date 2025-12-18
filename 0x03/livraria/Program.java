
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        try {
            Livro var1 = new Livro("As barbas do imperador: D. Pedro II", "Lilia Moritz Schwarcz", (double)56.0F);
            System.out.printf(new Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var1.getTitulo(), var1.getAutor(), var1.getPreco());
        } catch (Exception var6) {
            System.out.println(var6.getMessage() + "\n");
        }

        try {
            LivroEdicaoOuro var7 = new LivroEdicaoOuro("Xato", "Fernando Morais", 38.3);
            System.out.printf(new Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var7.getTitulo(), var7.getAutor(), var7.getPreco());
        } catch (Exception var5) {
            System.out.println(var5.getMessage() + "\n");
        }

        try {
            LivroEdicaoOuro var8 = new LivroEdicaoOuro("Ladrao de Raios", "Rick", 21.88);
            System.out.printf(new Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var8.getTitulo(), var8.getAutor(), var8.getPreco());
        } catch (Exception var4) {
            System.out.println(var4.getMessage() + "\n");
        }

        try {
            Livro var9 = new Livro("ab", "Jane Doe", 15.99);
            System.out.printf(new Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var9.getTitulo(), var9.getAutor(), var9.getPreco());
        } catch (Exception var3) {
            System.out.println(var3.getMessage() + "\n");
        }

        try {
            Livro var10 = new Livro("Harry Potter e o enigma do principe", "J.K. Rowling", (double)0.0F);
            System.out.printf(new Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var10.getTitulo(), var10.getAutor(), var10.getPreco());
        } catch (Exception var2) {
            System.out.println(var2.getMessage() + "\n");
        }
    }
}
