package br.com.unicesumar.controller;

import br.com.unicesumar.model.Movimentacao;
import br.com.unicesumar.model.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimentacaoController {
    private List<Movimentacao> movimentacoes;
    private ProdutoController produtoController;
    private int proximoId = 1;
    
    public MovimentacaoController(ProdutoController produtoController) {
        this.movimentacoes = new ArrayList<>();
        this.produtoController = produtoController;
    }
    
    // CREATE - Adicionar entrada de estoque
    public boolean adicionarEntrada(int idProduto, int quantidade, String observacao) {
        if (quantidade <= 0) {
            System.out.println("Erro: Quantidade deve ser maior que 0!");
            return false;
        }
        
        Produto produto = produtoController.buscarPorId(idProduto);
        if (produto == null) {
            return false;
        }
        
        // Atualizar quantidade do produto
        int novaQuantidade = produto.getQuantidade() + quantidade;
        produto.setQuantidade(novaQuantidade);
        
        // Registrar movimentação
        Movimentacao mov = new Movimentacao(proximoId++, "ENTRADA", quantidade, 
                                            new Date(), observacao);
        movimentacoes.add(mov);
        System.out.println("✓ Entrada de " + quantidade + " unidades registrada!");
        return true;
    }
    
    // CREATE - Adicionar saída de estoque
    public boolean adicionarSaida(int idProduto, int quantidade, String observacao) {
        if (quantidade <= 0) {
            System.out.println("Erro: Quantidade deve ser maior que 0!");
            return false;
        }
        
        Produto produto = produtoController.buscarPorId(idProduto);
        if (produto == null) {
            return false;
        }
        
        if (produto.getQuantidade() < quantidade) {
            System.out.println("Erro: Estoque insuficiente! Disponível: " + 
                             produto.getQuantidade());
            return false;
        }
        
        // Atualizar quantidade do produto
        int novaQuantidade = produto.getQuantidade() - quantidade;
        produto.setQuantidade(novaQuantidade);
        
        // Registrar movimentação
        Movimentacao mov = new Movimentacao(proximoId++, "SAIDA", quantidade, 
                                            new Date(), observacao);
        movimentacoes.add(mov);
        System.out.println("✓ Saída de " + quantidade + " unidades registrada!");
        return true;
    }
    
    // READ - Listar todas as movimentações
    public List<Movimentacao> listarTodasMovimentacoes() {
        return new ArrayList<>(movimentacoes);
    }
    
    // READ - Listar movimentações por tipo
    public List<Movimentacao> listarMovimentacoesPorTipo(String tipo) {
        List<Movimentacao> resultado = new ArrayList<>();
        for (Movimentacao m : movimentacoes) {
            if (m.getTipo().equals(tipo.toUpperCase())) {
                resultado.add(m);
            }
        }
        return resultado;
    }
    
    // RELATÓRIO - Histórico de movimentações
    public void exibirRelatorioDtmovimentacoes() {
        System.out.println("\n========== RELATÓRIO DE MOVIMENTAÇÕES ==========");
        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentação registrada.");
            return;
        }
        
        for (Movimentacao m : movimentacoes) {
            System.out.println("ID: " + m.getIdMovimentacao() + 
                             " | Tipo: " + m.getTipo() + 
                             " | Qtd: " + m.getQuantidade() + 
                             " | Data: " + m.getData() + 
                             " | Obs: " + m.getObservacao());
        }
        System.out.println("==============================================\n");
    }
}