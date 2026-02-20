import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProdutoDAO {

    public void inserir(Produto produto) {
        

        String sql = "INSERT INTO produto(codigo, nome, preco, quantidade) VALUES (?, ?, ?, ?)";

        try(Connection conex = Conexao.conectar();
            PreparedStatement ins = conex.prepareStatement(sql)) {
            

            ins.setInt(1, produto.getCodigo());
            ins.setString(2, produto.getNome());
            ins.setDouble(3, produto.getPreco());
            ins.setInt(4, produto.getQuantidade());

            ins.executeUpdate();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Produto> listar() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Connection conex = Conexao.conectar();
                PreparedStatement ins = conex.prepareStatement(sql);
                ResultSet rs = ins.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getInt("codigo")

                );

                lista.add(p);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}