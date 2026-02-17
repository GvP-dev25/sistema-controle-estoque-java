import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[100];
        int contador = 0;
        int opcao = 0;

        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Cadastrar Produto" +
                "\n 2 - Listar Produto" +
                "\n 3 - Atualizar Quantidade" +
                "\n 4 - Remover Produto" +
                "\n 5 - Buscar Produto" +
                "\n 6 - Sair"));

        if (opcao == 1) {
        } else if (opcao == 2) {
        } else if (opcao == 3) {
        } else if (opcao == 4) {
        } else if (opcao == 5) {
        } else if (opcao == 6) {
        }

    }

}