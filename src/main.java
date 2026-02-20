import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        SistemaProduto sistema = new SistemaProduto();
        int opcao;
        do {
            opcao = sistema.menu();

            switch (opcao) {
                case 1:
                    sistema.CadastrarProduto();
                    break;
                case 2:
                    sistema.listarProduto();
                    break;
                case 3:
                    sistema.AtualizarQuantidade();
                    break;
                case 4:
                    sistema.ExcrluirProduto();
                    break;

                case 5:
                    sistema.BuscarProduto();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite apenas opções validas.");
                    return;
            }
        } while (opcao != 6);
    }
}
