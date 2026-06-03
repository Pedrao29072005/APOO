package br.com.unicesumar.model;
import java.util.Date;

public class Relatorio {
    private int idRelatorio;
    private String tipo;
    private Date dataInicial;
    private Date dataFinal;
    private Date dataGeracao;
    private String arquivo;
    
    public Relatorio() {
    }
    
    public Relatorio(int idRelatorio, String tipo, Date dataInicial, Date dataFinal, 
                     Date dataGeracao, String arquivo) {
        this.idRelatorio = idRelatorio;
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.dataGeracao = dataGeracao;
        this.arquivo = arquivo;
    }
    
    public int getIdRelatorio() {
        return idRelatorio;
    }
    
    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Date getDataInicial() {
        return dataInicial;
    }
    
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public Date getDataFinal() {
        return dataFinal;
    }
    
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public Date getDataGeracao() {
        return dataGeracao;
    }
    
    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }
    
    public String getArquivo() {
        return arquivo;
    }
    
    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
}