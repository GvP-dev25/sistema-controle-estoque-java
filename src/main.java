import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static boolean verificarnome(ArrayList<Produto> produtos, String nome) {
        boolean existe = false;

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public static boolean verificarcodigo(ArrayList<Produto> produtos, int codigo) {
        boolean existe = false;

        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao;
        boolean nomeExiste;

        try{
            do{

        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Cadastrar Produto" +
                "\n 2 - Listar Produto" +
                "\n 3 - Atualizar Quantidade" +
                "\n 4 - Remover Produto" +
                "\n 5 - Buscar Produto" +
                "\n 6 - Sair"));




        if (opcao == 1) {
            String codigoStr, precoStr, nome, quantStr;
            int codigo, quant;
            double preco;


                        do {
                codigoStr = JOptionPane.showInputDialog(null, "Digite o código do produto: ");
                codigo = Integer.parseInt(codigoStr);

                nomeExiste = verificarcodigo(produtos, codigo);
                
                if(nomeExiste){
                    JOptionPane.showMessageDialog(null, "Codigo já existe!.");

                }
            } while (nomeExiste);

            do {
                nome = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
                 nomeExiste = verificarnome(produtos, nome);

                if(nomeExiste){
                    JOptionPane.showMessageDialog(null, "Nome já existe!.");

               }
            } while (nomeExiste);

            precoStr = JOptionPane.showInputDialog(null, "Digite o preço: ");
            preco = Double.parseDouble(precoStr);

            quantStr = JOptionPane.showInputDialog(null, "Digite a quantidade: ");
            quant = Integer.parseInt(quantStr);
            produtos.add(new Produto(nome, preco, quant, codigo));

        } else if (opcao == 2) {
        } else if (opcao == 3) {
        } else if (opcao == 4) {
        } else if (opcao == 5) {
        } else if (opcao == 6) {
        }

    }while(opcao != 6);

    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Digite apenas opções válidas...", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    }

}