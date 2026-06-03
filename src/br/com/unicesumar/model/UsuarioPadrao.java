package br.com.unicesumar.model;

public class UsuarioPadrao extends Usuario {
    
    public UsuarioPadrao() {
        super();
        // Usuário padrão tem permissões limitadas
        this.concederPermissao(Permission.VER_RELATORIOS);
    }
    
    @Override
    public void executarAcao() {
        System.out.println("   [USUÁRIO] Executando ações padrão do sistema");
    }
}
