public class Program {
    public static void main(String[] args) {
        try {
            Livro var1 = new Livro("As barbas do imperador: D. Pedro II", "Lilia Moritz Schwarcz", 56.0);
            System.out.printf(new java.util.Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var1.getTitulo(), var1.getAutor(), var1.getPreco());
        } catch (Exception var6) {
            System.out.println(var6.getMessage() + "\n");
        }

        try {
            LivroEdicaoOuro var7 = new LivroEdicaoOuro("Xato", "Fernando Morais", 38.3);
            System.out.printf(new java.util.Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var7.getTitulo(), var7.getAutor(), var7.getPreco());
        } catch (Exception var5) {
            System.out.println(var5.getMessage() + "\n");
        }

        try {
            LivroEdicaoOuro var8 = new LivroEdicaoOuro("Ladrao de Raios", "Rick", 21.88);
            System.out.printf(new java.util.Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var8.getTitulo(), var8.getAutor(), var8.getPreco());
        } catch (Exception var4) {
            System.out.println(var4.getMessage() + "\n");
        }

        try {
            Livro var9 = new Livro("ab", "Jane Doe", 15.99);
            System.out.printf(new java.util.Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var9.getTitulo(), var9.getAutor(), var9.getPreco());
        } catch (Exception var3) {
            System.out.println(var3.getMessage() + "\n");
        }

        try {
            Livro var10 = new Livro("Harry Potter e o enigma do principe", "J.K. Rowling", 0.0);
            System.out.printf(new java.util.Locale("pt", "BR"), "Titulo: %s - Autor: %s - Preco: %.2f\n", var10.getTitulo(), var10.getAutor(), var10.getPreco());
        } catch (Exception var2) {
            System.out.println(var2.getMessage() + "\n");
        }

    }
}

class Livro {
    private String titulo;
    private String autor;
    private double preco;

    public Livro(String var1, String var2, double var3) throws AutorInvalidoException, LivroInvalidoException {
        this.setTitulo(var1);
        this.setAutor(var2);
        this.setPreco(var3);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String var1) throws LivroInvalidoException {
        if (var1 != null && var1.trim().length() >= 3) {
            this.titulo = var1;
        } else {
            throw new LivroInvalidoException("Titulo de livro invalido");
        }
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String var1) throws AutorInvalidoException {
        if (var1 == null) {
            throw new AutorInvalidoException("Nome de autor invalido");
        } else {
            String[] var2 = var1.trim().split("\\s+");
            if (var2.length < 2) {
                throw new AutorInvalidoException("Nome de autor invalido");
            } else {
                this.autor = var1;
            }
        }
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double var1) throws LivroInvalidoException {
        if (var1 <= 0.0) {
            throw new LivroInvalidoException("Preco de livro invalido");
        } else {
            this.preco = var1;
        }
    }
}

class LivroEdicaoOuro extends Livro {
    public LivroEdicaoOuro(String var1, String var2, double var3) throws AutorInvalidoException, LivroInvalidoException {
        super(var1, var2, var3);
    }

    public double getPreco() {
        return super.getPreco() * 1.3;
    }
}

class AutorInvalidoException extends Exception {
    public AutorInvalidoException(String var1) {
        super(var1);
    }
}

class LivroInvalidoException extends Exception {
    public LivroInvalidoException(String var1) {
        super(var1);
    }
}

