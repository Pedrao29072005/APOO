package br.com.unicesumar.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Usuario {
    private int id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private boolean ativo;
    private Set<Permission> permissoes;
    
    public Usuario() {
        this.permissoes = new HashSet<>();
    }
    
    public Usuario(int id, String nome, String login, String senha, String email, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.ativo = ativo;
        this.permissoes = new HashSet<>();
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
    
    // Métodos de permissão
    public void concederPermissao(Permission p) {
        permissoes.add(p);
    }
    
    public void removerPermissao(Permission p) {
        permissoes.remove(p);
    }
    
    public boolean temPermissao(Permission p) {
        return permissoes.contains(p);
    }
    
    public Set<Permission> getPermissoes() {
        return new HashSet<>(permissoes);
    }
    
    // Método
    
    // Método abstrato - polimorfismo
    public abstract void executarAcao();
}