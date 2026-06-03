package br.com.unicesumar.model;

public class Categoria {
    private int idCategoria;
    private String nome;
    private String descricao;
    private boolean ativa;
    
    public Categoria() {
    }
    
    public Categoria(int idCategoria, String nome, String descricao, boolean ativa) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.ativa = ativa;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }
    
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public boolean isAtiva() {
        return ativa;
    }
    
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}