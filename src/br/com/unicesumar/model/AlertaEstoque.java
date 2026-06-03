package br.com.unicesumar.model;
import java.util.Date;

public class AlertaEstoque {
    private int idAlerta;
    private String mensagem;
    private Date dataGeracao;
    private boolean lido;
    
    public AlertaEstoque() {
    }
    
    public AlertaEstoque(int idAlerta, String mensagem, Date dataGeracao, boolean lido) {
        this.idAlerta = idAlerta;
        this.mensagem = mensagem;
        this.dataGeracao = dataGeracao;
        this.lido = lido;
    }
    
    public int getIdAlerta() {
        return idAlerta;
    }
    
    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Date getDataGeracao() {
        return dataGeracao;
    }
    
    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }
    
    public boolean isLido() {
        return lido;
    }
    
    public void setLido(boolean lido) {
        this.lido = lido;
    }
}