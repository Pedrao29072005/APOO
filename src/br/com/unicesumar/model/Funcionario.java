package br.com.unicesumar.model;

public class Funcionario extends Usuario {
    
    public Funcionario() {
        super();
        // Funcionário tem permissões limitadas
        this.concederPermissao(Permission.REGISTRAR_MOVIMENTACAO);
        this.concederPermissao(Permission.VER_RELATORIOS);
    }
    
    @Override
    public void executarAcao() {
        System.out.println("   [FUNCIONÁRIO] Executando ações: Registrando movimentações de estoque");
        registrarMovimentacao();
    }
    
    public void registrarMovimentacao() {
        System.out.println("   ✓ Movimentação registrada com sucesso no sistema!");
    }
    
    public void consultarEstoque(String produto) {
        System.out.println("   ✓ Consultando estoque do produto: '" + produto + "'");
    }
}