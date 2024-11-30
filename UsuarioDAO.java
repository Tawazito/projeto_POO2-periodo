package com.mycompany.telalogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tawaf
 */
public class UsuarioDAO {

    ConectaBD conectabd = new ConectaBD();
    Connection con = conectabd.conexao();

    //método para localizar cliente pelo cpf
    public Integer pesquisaUsuario(int id) throws SQLException {
        
        
        String sql = "SELECT * FROM cliente WHERE id = '" + id + "'";
        //cria uma conecxão no bd e faz a query no Banco
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        //se não encontrar cpf do cliente printa"não achou cliente"
        if (!rs.isBeforeFirst()) {
            System.out.println("Não achou o cliente!");
            return 0;
        } else {
            return rs.getInt("id,nome,cpf ");
        }

    }

    //método para atualizar dados de usuário cadastrado
    public void atualizarUsuario(int id, String sobrenome, String nome, String bairro, String cidade, String telefone) {
        String sql;
        
        try {
            if (nome.isEmpty()) {
                sql = "UPDATE usuario SET nome = ?, sobrenome = ?, bairro = ?, cidade = ?, telefone = ? WHERE id = ?";
                //evita inserção de código malicioso no banco
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, sobrenome);
                ps.setString(3, bairro);
                ps.setString(4, cidade);
                ps.setString(5, telefone);
                ps.executeUpdate();
            } else {
                sql = "UPDATE usuario SET nome = ?,sobrenome = ?, bairro = ?, cidade = ?, telefone  = ? WHERE id = ?";
                //evita inserção de código malicioso no banco
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, sobrenome);
                ps.setString(3, bairro);
                ps.setString(4, cidade);
                ps.setString(5, telefone);
                ps.executeUpdate();

            }
            System.out.println("Dados do usuário " + id + " foram atualizados!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados do usuário " + id + " " + e.getMessage());

        }

    }

    //método para inserir dados de usuário
    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(id, nome, sobrenome, bairro, cidade, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            //evita inserção de código malicioso no banco
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSobrenome());
            ps.setString(4, usuario.getBairro());
            ps.setString(5, usuario.getCidade());
            ps.setInt(6, usuario.getTelefone());
            ps.execute();
             
            JOptionPane.showMessageDialog(null, "cliente salvo");
            System.out.println("Dados do cleiente salvos com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar dados do cliente!" + e.getMessage());
        }
    }

    //método para excluir apenas um usuário
    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            //evita inserção de código malicioso no banco
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Dados do cliente " + id + " foram excluídos!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados do cliente " + id + " "
                    + e.getMessage());
        }
    }

    //método para listar todos os usuários
    /**
     *
     * @return
     */
    
    
    
    public void consultarCliente(String id ){
    
    
    
    }
    
    
    public List<Usuario> listarUsuario() {

        List<Usuario> dados = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.isBeforeFirst()) {
                System.out.println("A tabela usuário está vazia!");
            } else {
                while (rs.next()) {
                    Usuario usuarios = new Usuario();
                    usuarios.setId(rs.getInt("id"));
                    usuarios.setNome(rs.getString("nome"));
                    usuarios.setSobrenome(rs.getString("sobrenome"));
                    usuarios.setBairro(rs.getString("bairro"));
                    usuarios.setCidade(rs.getString("cidade"));
                    usuarios.setTelefone(rs.getInt("telefone"));
                    dados.add(usuarios);

                    System.out.println("ID: " + rs.getString("id"));
                    System.out.println("NOME: " + rs.getString("nome"));
                    System.out.println("SOBRENOME: " + rs.getString("sobrenome"));
                    System.out.println("BAIRRO: " + rs.getString("bairro"));
                    System.out.println("CIDADE: " + rs.getString("cidade"));
                    System.out.println("TELEFONE: " + rs.getString("telefone"));

                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar dados de usuário!");

        }
        return dados;

    }

    public int ultimoId() {
        String sql = "SELECT last_insert_rowid(), id FROM usuario";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                //resultset retorna apenas string. Converte de string para int
                return Integer.parseInt(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void consultar_Funcionario() {
       String sql =  " SELECT USUARIO, SENHA " + "FROM USUARIO";
    }
}
