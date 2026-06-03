package br.com.unicesumar;

import br.com.unicesumar.controller.ProdutoController;
import br.com.unicesumar.controller.UsuarioController;
import br.com.unicesumar.controller.MovimentacaoController;
import br.com.unicesumar.model.Produto;
import br.com.unicesumar.model.Usuario;

public class Main {
    public static void main(String[] args) {
        // Inicializar controllers
        ProdutoController produtoCtrl = new ProdutoController();
        UsuarioController usuarioCtrl = new UsuarioController();
        MovimentacaoController movimentacaoCtrl = new MovimentacaoController(produtoCtrl);
        
        System.out.println("========== SISTEMA DE ESTOQUE ==========\n");
        
        // ===== USUÁRIOS =====
        System.out.println("--- Registrando Usuários ---");
        usuarioCtrl.registrarUsuario("João Silva", "joao123", "joao@email.com", "senha123");
        usuarioCtrl.registrarUsuario("Maria Santos", "maria456", "maria@email.com", "senha456");
        
        System.out.println("\n--- Login de Usuário ---");
        usuarioCtrl.login("joao123", "senha123");
        
        // ===== PRODUTOS =====
        System.out.println("\n--- Adicionando Produtos ---");
        produtoCtrl.adicionarProduto("Notebook", "Notebook Intel i7", 15, 2500.00, 5, "unidade");
        produtoCtrl.adicionarProduto("Mouse", "Mouse sem fio", 50, 45.00, 20, "unidade");
        produtoCtrl.adicionarProduto("Teclado", "Teclado mecânico", 30, 150.00, 10, "unidade");
        
        // ===== MOVIMENTAÇÕES =====
        System.out.println("\n--- Movimentações de Estoque ---");
        movimentacaoCtrl.adicionarEntrada(1, 5, "Compra fornecedor A");
        movimentacaoCtrl.adicionarSaida(2, 10, "Venda para cliente B");
        movimentacaoCtrl.adicionarSaida(3, 5, "Devolução de cliente");
        
        // ===== CONSULTAS =====
        System.out.println("\n--- Produtos com Estoque Baixo ---");
        for (Produto p : produtoCtrl.produtosComEstoqueBaixo()) {
            System.out.println("⚠ Produto: " + p.getNome() + 
                             " | Estoque: " + p.getQuantidade() + 
                             " | Mínimo: " + p.getEstoqueMinimo());
        }
        
        System.out.println("\n--- Valor Total do Estoque ---");
        System.out.println("R$ " + String.format("%.2f", produtoCtrl.calcularValorTotalEstoque()));
        
        // ===== RELATÓRIO =====
        movimentacaoCtrl.exibirRelatorioDtmovimentacoes();
        
        System.out.println("\n--- Logout ---");
        usuarioCtrl.logout();
    }
}
