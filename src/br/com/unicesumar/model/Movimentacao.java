package br.com.unicesumar.model;

import java.util.Date;

public class Movimentacao {
    private int idMovimentacao;
    private String tipo;
    private int quantidade;
    private Date data;
    private String observacao;
    
    public Movimentacao() {
    }
    
    public Movimentacao(int idMovimentacao, String tipo, int quantidade, Date data, String observacao) {
        this.idMovimentacao = idMovimentacao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.observacao = observacao;
    }
    
    // Getters e Setters
    public int getIdMovimentacao() {
        return idMovimentacao;
    }
    
    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public String getObservacao() {
        return observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}