package br.com.unicesumar.model;

public class Administrador extends Usuario {
    
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