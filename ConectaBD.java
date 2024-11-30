package com.mycompany.telalogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tawaf
 */
public class ConectaBD {
    //criei um método publico de coneção

    public Connection conexao() {
        String banco = "jdbc:sqlite:teste.db";
        String usuario = "CREATE TABLE IF NOT EXISTS usuario (id integer, nome string, email string, senha string)";
        Connection con = null;
        try {
            con = DriverManager.getConnection(banco);
            Statement st = con.createStatement();
            st.execute(usuario);
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar ao banco " + e.getMessage());
        }
        System.out.println("Conectado ao banco de dados com sucesso!");
        return con;
    }

}
