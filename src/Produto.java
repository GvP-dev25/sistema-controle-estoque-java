public class Produto {

    private String nome;
    private double preco;
    private int quantidade;
    private int codigo;

    public Produto(String nome, double preco, int quantidade, int codigo) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                "\n Nome: " + nome +
                "\n Preço: " + preco +
                "\n Quantidade: " + quantidade;

    }

}