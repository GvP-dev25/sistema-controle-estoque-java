import javax.swing.JOptionPane;
import java.util.ArrayList;

public class SistemaProduto {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public SistemaProduto() {
    }

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

    public int menu() {
        String opcaoStr;
        int opcao = 0;

        do {
            try {

                opcaoStr = JOptionPane.showInputDialog(null, "1 - Cadastrar Produto" +
                        "\n 2 - Listar Produto" +
                        "\n 3 - Atualizar Quantidade" +
                        "\n 4 - Remover Produto" +
                        "\n 5 - Buscar Produto" +
                        "\n 6 - Sair");

                if (opcaoStr == null) {
                    JOptionPane.showMessageDialog(null, "Operação cancelada.");
                    break;
                }
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas opções válidas...", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }
        } while (opcao < 1 || opcao > 6);
        return opcao;
    }

    public void CadastrarProduto() {

        boolean nomeExiste = false, codigoExiste = false, valido = false;
        String codigoStr, precoStr, nome, quantStr;
        int codigo = 0, quant = 0;
        double preco = 0;

        do {
            valido = false;
            codigoStr = JOptionPane.showInputDialog("Digite o código do produto:");
            if (codigoStr == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }

            if (!codigoStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
                continue;
            }
            codigo = Integer.parseInt(codigoStr);
            codigoExiste = verificarcodigo(produtos, codigo);

            if (codigoExiste) {
                JOptionPane.showMessageDialog(null, "Código já existe!");
            } else {
                valido = true;
            }

        } while (!valido);

        do {
            valido = false;
            nome = JOptionPane.showInputDialog("Digite o nome do produto:");
            if (nome == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }

            if (nome.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Não é permitido números no nome.");

                continue;
            }
            nomeExiste = verificarnome(produtos, nome);

            if (nomeExiste) {
                JOptionPane.showMessageDialog(null, "Nome já existe!");
            } else {
                valido = true;
            }

        } while (!valido);
        do {
            valido = false;
            precoStr = JOptionPane.showInputDialog(null, "Digite o preço: ");

            if (precoStr == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }
            precoStr = precoStr.replace(",", ".");
            if (precoStr.matches("\\d+(\\.\\d+)?")) {
                preco = Double.parseDouble(precoStr);
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
            }

        } while (!valido);

        do {
            valido = false;
            quantStr = JOptionPane.showInputDialog(null, "Digite a quantidade: ");
            if (quantStr == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }
            if (quantStr.matches("\\d+")) {
                quant = Integer.parseInt(quantStr);
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
            }

        } while (!valido);
        Produto novo = new Produto(nome, preco, quant, codigo);
        produtos.add(novo);
    }

public void listarProduto(){
    String mensagem = "";
    if(produtos.isEmpty()){
        JOptionPane.showMessageDialog(null, "Não tem nenhum produto cadastrado.");
        return;
    }

for(Produto p : produtos){
    mensagem += p.toString() + "\n\n";
}
JOptionPane.showMessageDialog(null, mensagem);
}





}
