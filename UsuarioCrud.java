package com.mycompany.telalogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tawaf
 */
public class UsuarioCrud {

    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection conexao = databaseConnection.conectaDB("banco de dados: livraria Java");

    public void novoUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(id, nome,sobrenome, telefone) VALUES(?, ?, ?, ?);";
        try {
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
            ps.setInt(2, usuario.getId());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSobrenome());
            ps.setInt(4, usuario.getTelefone());

            ps.execute();
            System.out.println("Usuário salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id=?;";
        try {
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Usuário: " + id + " excluído com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizarUsuario(String nome, String sobrenome, String bairro, int telefone) {
        String sql = "UPDATE usuario SET nome=?, sobrenome=?, bairro=?, telefone;";
        try {
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, sobrenome);
            ps.setString(3, bairro);
            ps.setInt(4, telefone);
            ps.execute();
            System.out.println("Usuário: " + nome + " atulizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //metodo par alistar usuários
    public Usuario listarUsuarios(Usuario Usuario) {
        String sql = "SELECT * FROM usuario;";
        List<Usuario> dados = new ArrayList<>();
        Usuario usuario = null;
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setBairro(rs.getString("birro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setTelefone(rs.getInt("telefone"));
                dados.add(usuario);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return (Usuario) dados;

    }
}
