package br.com.unicesumar.model;

public class Administrador extends Usuario {
    
    public Administrador() {
        super();
        // Administrador tem todas as permissões
        this.concederPermissao(Permission.CRIAR_PRODUTOS);
        this.concederPermissao(Permission.EDITAR_PRODUTOS);
        this.concederPermissao(Permission.DELETAR_PRODUTOS);
        this.concederPermissao(Permission.REGISTRAR_MOVIMENTACAO);
        this.concederPermissao(Permission.GERENCIAR_USUARIOS);
        this.concederPermissao(Permission.VER_RELATORIOS);
    }
    
    @Override
    public void executarAcao() {
        System.out.println("   [ADMINISTRADOR] Executando ações: Gerenciando usuários, definindo permissões e monitorando sistema");
        gerenciarUsuarios();
    }
    
    public void gerenciarUsuarios() {
        System.out.println("   ✓ Usuários gerenciados com sucesso!");
    }
    
    public void definirPermissoes(String usuario, String permissao) {
        System.out.println("   ✓ Permissão '" + permissao + "' atribuída ao usuário '" + usuario + "'");
    }
}