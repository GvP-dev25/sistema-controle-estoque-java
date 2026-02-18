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

                if (opcao == 1) {
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
                    produtos.add(new Produto(nome, preco, quant, codigo));

                } else if (opcao == 2) {
                } else if (opcao == 3) {
                } else if (opcao == 4) {
                } else if (opcao == 5) {
                } else if (opcao == 6) {
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas opções válidas...", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

        } while (opcao != 6);

    }

}