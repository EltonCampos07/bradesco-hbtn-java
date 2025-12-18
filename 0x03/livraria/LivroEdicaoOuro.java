 public class LivroEdicaoOuro extends Livro {
    public LivroEdicaoOuro(String var1, String var2, double var3) throws AutorInvalidoException, LivroInvalidoException {
        super(var1, var2, var3);
    }

    public double getPreco() {
        return super.getPreco() * 1.3;
    }
}
