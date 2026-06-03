package br.com.unicesumar.controller;

import br.com.unicesumar.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoController {
    private List<Produto> produtos;
    private int proximoId = 1;
    
    public ProdutoController() {
        this.produtos = new ArrayList<>();
    }
    
    // CREATE - Adicionar novo produto
    public boolean adicionarProduto(String nome, String descricao, int quantidade, 
                                    double preco, int estoqueMinimo, String unidade) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: Nome do produto não pode estar vazio!");
            return false;
        }
        
        if (preco < 0) {
            System.out.println("Erro: Preço não pode ser negativo!");
            return false;
        }
        
        if (quantidade < 0) {
            System.out.println("Erro: Quantidade não pode ser negativa!");
            return false;
        }
        
        Produto novoProduto = new Produto(proximoId++, nome, descricao, quantidade, 
                                          preco, estoqueMinimo, unidade, true);
        produtos.add(novoProduto);
        System.out.println("✓ Produto '" + nome + "' adicionado com sucesso!");
        return true;
    }
    
    // READ - Buscar produto por ID
    public Produto buscarPorId(int id) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getIdProduto() == id)
                .findFirst();
        
        if (produto.isPresent()) {
            return produto.get();
        }
        System.out.println("Erro: Produto com ID " + id + " não encontrado!");
        return null;
    }
    
    // READ - Listar todos os produtos ativos
    public List<Produto> listarProdutosAtivos() {
        List<Produto> ativos = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.isAtivo()) {
                ativos.add(p);
            }
        }
        return ativos;
    }
    
    // UPDATE - Atualizar informações do produto
    public boolean atualizarProduto(int id, String nome, String descricao, 
                                    double preco, int estoqueMinimo) {
        Produto produto = buscarPorId(id);
        
        if (produto == null) {
            return false;
        }
        
        if (preco < 0) {
            System.out.println("Erro: Preço não pode ser negativo!");
            return false;
        }
        
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setEstoqueMinimo(estoqueMinimo);
        System.out.println("✓ Produto atualizado com sucesso!");
        return true;
    }
    
    // DELETE - Desativar produto (soft delete)
    public boolean desativarProduto(int id) {
        Produto produto = buscarPorId(id);
        
        if (produto == null) {
            return false;
        }
        
        produto.setAtivo(false);
        System.out.println("✓ Produto desativado com sucesso!");
        return true;
    }
    
    // LÓGICA DE NEGÓCIO - Verificar estoque baixo
    public List<Produto> produtosComEstoqueBaixo() {
        List<Produto> comEstoqueBaixo = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.isAtivo() && p.getQuantidade() < p.getEstoqueMinimo()) {
                comEstoqueBaixo.add(p);
            }
        }
        return comEstoqueBaixo;
    }
    
    // LÓGICA DE NEGÓCIO - Calcular valor total do estoque
    public double calcularValorTotalEstoque() {
        double total = 0;
        for (Produto p : produtos) {
            if (p.isAtivo()) {
                total += p.getQuantidade() * p.getPreco();
            }
        }
        return total;
    }
    
    // Listar todos
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }
}
