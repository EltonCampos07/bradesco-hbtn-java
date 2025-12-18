package livraria;

import livraria.exceptions.AutorInvalidoException;
import livraria.exceptions.LivroInvalidoException;

public class Livro {
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
        if (var1 <= (double)0.0F) {
            throw new LivroInvalidoException("Preco de livro invalido");
        } else {
            this.preco = var1;
        }
    }
}
