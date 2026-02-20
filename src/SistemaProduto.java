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

    public void listarProduto() {
        String mensagem = "";
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não tem nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            mensagem += p.toString() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public boolean atualizarQuant(String nome, int quant) {

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.setQuantidade(quant);
                return true;
            }

        }
        return false;
    }

    public boolean excluirProduto(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                produtos.remove(i);
                return true;
            }
        }

        return false;

    }

    public void procurarProduton(String nome) {
        String mensagem = "";
        for (Produto p : produtos) {

            if (p.getNome().equalsIgnoreCase(nome)) {
                mensagem += p.toString();
                JOptionPane.showMessageDialog(null, mensagem);
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado.");

    }

    public void procurarProdutoc(int codigo) {
        String mensagem = "";
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                mensagem += p.toString();
                JOptionPane.showMessageDialog(null, mensagem);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
            }
        }
    }

    public void AtualizarQuantidade() {
        String quantStr;
        boolean valido = false;
        do {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
            if (nome == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }
            else if(nome.matches(".*\\d+.*")){
                JOptionPane.showMessageDialog(null, "Invalido.");
                return;
            }
            quantStr = JOptionPane.showInputDialog(null, "Nova quantidade: ");
            if (quantStr == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }
           else if (!quantStr.matches(".*\\d+.*")) {
            JOptionPane.showMessageDialog(null, "Digite apenas numeros.");
               return;
            }
            else{
            int quant = Integer.parseInt(quantStr);
            boolean atualizado = atualizarQuant(nome, quant);
            if (atualizado) {
                JOptionPane.showMessageDialog(null, "Quantidade Atualizada.");
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                return;
            }
        }
        } while (!valido);

    }

    public void ExcrluirProduto() {
        String nome1;
        boolean valido = false;
        do {
            nome1 = JOptionPane.showInputDialog(null, "Nome produto:");
            if (nome1 == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }

            boolean excluir = excluirProduto(nome1);

            if (excluir) {
                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                return;
            }
        } while (!valido);

    }

    public void BuscarProduto() {
        String opcaoStr, nome2, codigoStr;
        int escolha, codigo;
        do {
            JOptionPane.showMessageDialog(null, "Escolha como deseja procurar o produto.");
            opcaoStr = JOptionPane.showInputDialog(null, "1 - Nome\n 2 - Código");
            if (opcaoStr == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }

            try {
                escolha = Integer.parseInt(opcaoStr);
                if (escolha != 1 && escolha != 2) {
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
                escolha = 0;
            }
        } while (escolha != 1 && escolha != 2);

        switch (escolha) {
            case 1:
                nome2 = JOptionPane.showInputDialog(null, "Digite o nome do produto:");
                if (nome2.matches(".*\\d+.*")) {
                    JOptionPane.showMessageDialog(null, "Não é permitido numeros.");
                    break;
                } else {
                    procurarProduton(nome2);
                }
                break;
            case 2:
                codigoStr = JOptionPane.showInputDialog(null, "Digite o código do produto:");
                if (codigoStr.matches("\\d+")) {
                    codigo = Integer.parseInt(codigoStr);
                    procurarProdutoc(codigo);
                } else {
                    JOptionPane.showMessageDialog(null, "Não é permitido letras no código.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Digite apenas opções validas.");
                break;

        }

    }

}
