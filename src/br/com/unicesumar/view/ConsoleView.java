package br.com.unicesumar.view;

import br.com.unicesumar.controller.ProdutoController;
import br.com.unicesumar.controller.UsuarioController;
import br.com.unicesumar.controller.MovimentacaoController;
import br.com.unicesumar.model.Administrador;
import br.com.unicesumar.model.Funcionario;
import br.com.unicesumar.model.Permission;
import br.com.unicesumar.model.Produto;
import br.com.unicesumar.model.Usuario;
import java.util.Scanner;
import java.util.List;

/**
 * Classe responsável pela interface com o usuário via console
 * Permite entrada de dados com validação de permissões
 */
public class ConsoleView {
    private Scanner scanner;
    private UsuarioController usuarioController;
    private ProdutoController produtoController;
    private MovimentacaoController movimentacaoController;
    private Usuario usuarioLogado;
    private boolean rodando;
    
    public ConsoleView(UsuarioController uc, ProdutoController pc, MovimentacaoController mc) {
        this.scanner = new Scanner(System.in);
        this.usuarioController = uc;
        this.produtoController = pc;
        this.movimentacaoController = mc;
        this.usuarioLogado = null;
        this.rodando = true;
    }
    
    /**
     * Inicia o menu principal da aplicação
     */
    public void iniciar() {
        System.out.println("========== BEM-VINDO AO SISTEMA DE ESTOQUE ==========\n");
        
        while (rodando) {
            if (usuarioLogado == null) {
                exibirMenuLogin();
            } else {
                exibirMenuPrincipal();
            }
        }
        
        scanner.close();
        System.out.println("\n✓ Encerrando sistema...");
    }
    
    /**
     * Menu de login - permite registrar novo usuário ou fazer login
     */
    private void exibirMenuLogin() {
        System.out.println("\n========== LOGIN / REGISTRO ==========");
        System.out.println("1. Fazer Login");
        System.out.println("2. Criar Novo Usuário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        
        String opcao = scanner.nextLine().trim();
        
        switch(opcao) {
            case "1":
                fazerLogin();
                break;
            case "2":
                registrarNovoUsuario();
                break;
            case "0":
                rodando = false;
                break;
            default:
                System.out.println("❌ Opção inválida!");
        }
    }
    
    /**
     * Processa o login do usuário
     */
    private void fazerLogin() {
        System.out.print("Login: ");
        String login = scanner.nextLine().trim();
        System.out.print("Senha: ");
        String senha = scanner.nextLine().trim();
        
        if (usuarioController.login(login, senha)) {
            usuarioLogado = usuarioController.buscarPorLogin(login);
            System.out.println("\n✓ Login realizado com sucesso!");
            System.out.println("Bem-vindo " + usuarioLogado.getNome() + "!");
        } else {
            System.out.println("❌ Erro: Login ou senha inválidos!");
        }
    }
    
    /**
     * Permite registrar um novo usuário (com seleção de tipo)
     */
    private void registrarNovoUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Login: ");
        String login = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Senha: ");
        String senha = scanner.nextLine().trim();
        
        System.out.println("\nTipo de Usuário:");
        System.out.println("1. Administrador");
        System.out.println("2. Funcionário");
        System.out.println("3. Usuário Padrão");
        System.out.print("Escolha o tipo: ");
        
        String tipo = scanner.nextLine().trim();
        
        usuarioController.registrarUsuarioComTipo(nome, login, email, senha, tipo);
    }
    
    /**
     * Menu principal - exibe opções baseadas nas permissões do usuário
     */
    private void exibirMenuPrincipal() {
        System.out.println("\n========== MENU PRINCIPAL - " + usuarioLogado.getNome() + " ==========");
        System.out.println("1. Gerenciar Produtos");
        System.out.println("2. Registrar Movimentação de Estoque");
        System.out.println("3. Ver Relatórios");
        System.out.println("4. Gerenciar Usuários");
        System.out.println("5. Minhas Permissões");
        System.out.println("0. Logout");
        System.out.print("Escolha uma opção: ");
        
        String opcao = scanner.nextLine().trim();
        
        switch(opcao) {
            case "1":
                if (usuarioLogado.temPermissao(Permission.CRIAR_PRODUTOS) || 
                    usuarioLogado.temPermissao(Permission.EDITAR_PRODUTOS)) {
                    gerenciarProdutos();
                } else {
                    System.out.println("❌ Acesso negado! Você não tem permissão para gerenciar produtos.");
                }
                break;
            case "2":
                if (usuarioLogado.temPermissao(Permission.REGISTRAR_MOVIMENTACAO)) {
                    registrarMovimentacao();
                } else {
                    System.out.println("❌ Acesso negado! Você não tem permissão para registrar movimentações.");
                }
                break;
            case "3":
                if (usuarioLogado.temPermissao(Permission.VER_RELATORIOS)) {
                    verRelatorios();
                } else {
                    System.out.println("❌ Acesso negado! Você não tem permissão para ver relatórios.");
                }
                break;
            case "4":
                if (usuarioLogado.temPermissao(Permission.GERENCIAR_USUARIOS)) {
                    gerenciarUsuarios();
                } else {
                    System.out.println("❌ Acesso negado! Você não tem permissão para gerenciar usuários.");
                }
                break;
            case "5":
                exibirMinhasPermissoes();
                break;
            case "0":
                usuarioController.logout();
                usuarioLogado = null;
                System.out.println("✓ Logout realizado com sucesso!");
                break;
            default:
                System.out.println("❌ Opção inválida!");
        }
    }
    
    /**
     * Submenu para gerenciar produtos
     */
    private void gerenciarProdutos() {
        boolean voltarMenu = false;
        while (!voltarMenu) {
            System.out.println("\n========== GERENCIAR PRODUTOS ==========");
            System.out.println("1. Adicionar Novo Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Deletar Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            String opcao = scanner.nextLine().trim();
            
            switch(opcao) {
                case "1":
                    if (usuarioLogado.temPermissao(Permission.CRIAR_PRODUTOS)) {
                        adicionarProduto();
                    } else {
                        System.out.println("❌ Acesso negado!");
                    }
                    break;
                case "2":
                    listarProdutos();
                    break;
                case "3":
                    if (usuarioLogado.temPermissao(Permission.EDITAR_PRODUTOS)) {
                        atualizarProduto();
                    } else {
                        System.out.println("❌ Acesso negado!");
                    }
                    break;
                case "4":
                    if (usuarioLogado.temPermissao(Permission.DELETAR_PRODUTOS)) {
                        deletarProduto();
                    } else {
                        System.out.println("❌ Acesso negado!");
                    }
                    break;
                case "0":
                    voltarMenu = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }
    
    /**
     * Adiciona um novo produto ao sistema
     */
    private void adicionarProduto() {
        System.out.println("\n--- Adicionar Novo Produto ---");
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine().trim();
        System.out.print("Quantidade inicial: ");
        int quantidade = lerInteiro();
        System.out.print("Preço (R$): ");
        double preco = lerDouble();
        System.out.print("Estoque mínimo: ");
        int estoqueMinimo = lerInteiro();
        System.out.print("Unidade (ex: unidade, kg, litro): ");
        String unidade = scanner.nextLine().trim();
        
        produtoController.adicionarProduto(nome, descricao, quantidade, preco, estoqueMinimo, unidade);
    }
    
    /**
     * Lista todos os produtos ativos
     */
    private void listarProdutos() {
        System.out.println("\n========== LISTA DE PRODUTOS ==========");
        List<Produto> produtos = produtoController.listarProdutosAtivos();
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado.");
            return;
        }
        
        for (Produto p : produtos) {
            System.out.println("ID: " + p.getIdProduto() + 
                             " | Nome: " + p.getNome() + 
                             " | Qtd: " + p.getQuantidade() + 
                             " | Preço: R$ " + String.format("%.2f", p.getPreco()));
        }
    }
    
    /**
     * Atualiza informações de um produto
     */
    private void atualizarProduto() {
        System.out.println("\n--- Atualizar Produto ---");
        listarProdutos();
        System.out.print("ID do produto a atualizar: ");
        int id = lerInteiro();
        
        Produto produto = produtoController.buscarPorId(id);
        if (produto == null) {
            System.out.println("❌ Produto não encontrado!");
            return;
        }
        
        System.out.print("Novo nome (deixe em branco para manter '" + produto.getNome() + "'): ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) nome = produto.getNome();
        
        System.out.print("Nova descrição (deixe em branco para manter '" + produto.getDescricao() + "'): ");
        String descricao = scanner.nextLine().trim();
        if (descricao.isEmpty()) descricao = produto.getDescricao();
        
        System.out.print("Novo preço (deixe em branco para manter R$ " + produto.getPreco() + "): ");
        String precoStr = scanner.nextLine().trim();
        double preco = precoStr.isEmpty() ? produto.getPreco() : Double.parseDouble(precoStr);
        
        System.out.print("Novo estoque mínimo (deixe em branco para manter " + produto.getEstoqueMinimo() + "): ");
        String estoqueMinStr = scanner.nextLine().trim();
        int estoqueMinimo = estoqueMinStr.isEmpty() ? produto.getEstoqueMinimo() : Integer.parseInt(estoqueMinStr);
        
        produtoController.atualizarProduto(id, nome, descricao, preco, estoqueMinimo);
    }
    
    /**
     * Deleta um produto (soft delete)
     */
    private void deletarProduto() {
        System.out.println("\n--- Deletar Produto ---");
        listarProdutos();
        System.out.print("ID do produto a deletar: ");
        int id = lerInteiro();
        
        produtoController.desativarProduto(id);
    }
    
    /**
     * Submenu para registrar movimentações de estoque
     */
    private void registrarMovimentacao() {
        System.out.println("\n========== REGISTRAR MOVIMENTAÇÃO ==========");
        System.out.println("1. Entrada de Estoque");
        System.out.println("2. Saída de Estoque");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        
        String opcao = scanner.nextLine().trim();
        
        switch(opcao) {
            case "1":
                registrarEntrada();
                break;
            case "2":
                registrarSaida();
                break;
            case "0":
                break;
            default:
                System.out.println("❌ Opção inválida!");
        }
    }
    
    /**
     * Registra entrada de estoque
     */
    private void registrarEntrada() {
        System.out.println("\n--- Entrada de Estoque ---");
        listarProdutos();
        System.out.print("ID do produto: ");
        int idProduto = lerInteiro();
        System.out.print("Quantidade: ");
        int quantidade = lerInteiro();
        System.out.print("Observação: ");
        String observacao = scanner.nextLine().trim();
        
        movimentacaoController.adicionarEntrada(idProduto, quantidade, observacao);
    }
    
    /**
     * Registra saída de estoque
     */
    private void registrarSaida() {
        System.out.println("\n--- Saída de Estoque ---");
        listarProdutos();
        System.out.print("ID do produto: ");
        int idProduto = lerInteiro();
        System.out.print("Quantidade: ");
        int quantidade = lerInteiro();
        System.out.print("Observação: ");
        String observacao = scanner.nextLine().trim();
        
        movimentacaoController.adicionarSaida(idProduto, quantidade, observacao);
    }
    
    /**
     * Exibe relatórios do sistema
     */
    private void verRelatorios() {
        System.out.println("\n========== RELATÓRIOS ==========");
        System.out.println("1. Produtos com Estoque Baixo");
        System.out.println("2. Valor Total do Estoque");
        System.out.println("3. Histórico de Movimentações");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        
        String opcao = scanner.nextLine().trim();
        
        switch(opcao) {
            case "1":
                exibirEstoqueBaixo();
                break;
            case "2":
                exibirValorTotal();
                break;
            case "3":
                exibirHistoricoMovimentacoes();
                break;
            case "0":
                break;
            default:
                System.out.println("❌ Opção inválida!");
        }
    }
    
    /**
     * Exibe produtos com estoque baixo
     */
    private void exibirEstoqueBaixo() {
        System.out.println("\n========== PRODUTOS COM ESTOQUE BAIXO ==========");
        List<Produto> produtos = produtoController.produtosComEstoqueBaixo();
        
        if (produtos.isEmpty()) {
            System.out.println("✓ Nenhum produto com estoque baixo!");
            return;
        }
        
        for (Produto p : produtos) {
            System.out.println("⚠ " + p.getNome() + 
                             " | Estoque: " + p.getQuantidade() + 
                             " | Mínimo: " + p.getEstoqueMinimo());
        }
    }
    
    /**
     * Exibe valor total do estoque
     */
    private void exibirValorTotal() {
        System.out.println("\n========== VALOR TOTAL DO ESTOQUE ==========");
        double valor = produtoController.calcularValorTotalEstoque();
        System.out.println("R$ " + String.format("%.2f", valor));
    }
    
    /**
     * Exibe histórico de movimentações
     */
    private void exibirHistoricoMovimentacoes() {
        System.out.println("\n========== HISTÓRICO DE MOVIMENTAÇÕES ==========");
        movimentacaoController.exibirRelatorioDtmovimentacoes();
    }
    
    /**
     * Submenu para gerenciar usuários (apenas para administradores)
     */
    private void gerenciarUsuarios() {
        System.out.println("\n========== GERENCIAR USUÁRIOS ==========");
        System.out.println("1. Listar Usuários");
        System.out.println("2. Criar Novo Usuário");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        
        String opcao = scanner.nextLine().trim();
        
        switch(opcao) {
            case "1":
                listarUsuarios();
                break;
            case "2":
                registrarNovoUsuario();
                break;
            case "0":
                break;
            default:
                System.out.println("❌ Opção inválida!");
        }
    }
    
    /**
     * Lista todos os usuários do sistema
     */
    private void listarUsuarios() {
        System.out.println("\n========== LISTA DE USUÁRIOS ==========");
        usuarioController.listarUsuarios();
    }
    
    /**
     * Exibe as permissões do usuário logado
     */
    private void exibirMinhasPermissoes() {
        System.out.println("\n========== MINHAS PERMISSÕES ==========");
        System.out.println("Usuário: " + usuarioLogado.getNome());
        System.out.println("Tipo: " + usuarioLogado.getClass().getSimpleName());
        System.out.println("\nPermissões:");
        
        java.util.Set<Permission> permissoes = usuarioLogado.getPermissoes();
        if (permissoes.isEmpty()) {
            System.out.println("  Nenhuma permissão atribuída.");
        } else {
            for (Permission p : permissoes) {
                System.out.println("  ✓ " + p.getDescricao());
            }
        }
    }
    
    /**
     * Métodos auxiliares para leitura de entrada
     */
    private int lerInteiro() {
        while (true) {
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("❌ Valor inválido! Digite um número inteiro: ");
            }
        }
    }
    
    private double lerDouble() {
        while (true) {
            try {
                double valor = Double.parseDouble(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("❌ Valor inválido! Digite um número: ");
            }
        }
    }
}
