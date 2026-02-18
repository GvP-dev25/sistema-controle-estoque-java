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
                String quantStr;
                
                String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
                quantStr = JOptionPane.showInputDialog(null, "Nova quantidade: ");
                int quant = Integer.parseInt(quantStr);
                boolean atualizado = sistema.atualizarQuant(nome, quant);
                if(atualizado == true){
                    JOptionPane.showMessageDialog(null, "Quantidade Atualizada.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                }
            } else if (opcao == 4) {
            } else if (opcao == 5) {
            } else if (opcao == 6) {
            }
        } while (opcao != 6);
    }

}