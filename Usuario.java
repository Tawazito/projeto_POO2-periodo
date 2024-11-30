
package com.mycompany.telalogin;

public class Usuario {
    private int id;
    private String nome;
    private String sobrenome;
    private String bairro;
    private String cidade;
    private int telefone;
    
    
    
    
    
     
    public Usuario() {
       
    }
    
    
    
    
    public Usuario(int id, String nome, String sobrenome, String bairro, String cidade, int telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefone = telefone;
    }
    
    
    
    
    

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    
    
}
