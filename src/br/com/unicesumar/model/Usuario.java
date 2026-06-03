package br.com.unicesumar.model;

public abstract class Usuario {
    private int id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private boolean ativo;
    
    public Usuario() {
    }
    
    public Usuario(int id, String nome, String login, String senha, String email, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.ativo = ativo;
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
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    // Método abstrato - polimorfismo
    public abstract void executarAcao();
}