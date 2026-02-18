import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        SistemaProduto sistema = new SistemaProduto();
        int opcao;
        do {
            opcao = sistema.menu();
            
            if (opcao == 1) {
                sistema.CadastrarProduto();
                continue;
            } else if (opcao == 2) {
               sistema.listarProduto();
               continue;
            } else if (opcao == 3) {
            } else if (opcao == 4) {
            } else if (opcao == 5) {
            } else if (opcao == 6) {
            }
        } while (opcao != 6);
    }

}