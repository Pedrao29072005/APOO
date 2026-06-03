package br.com.unicesumar.model;

/**
 * Enum que define as permissões disponíveis no sistema
 */
public enum Permission {
    CRIAR_PRODUTOS("Criar Produtos"),
    EDITAR_PRODUTOS("Editar Produtos"),
    DELETAR_PRODUTOS("Deletar Produtos"),
    REGISTRAR_MOVIMENTACAO("Registrar Movimentação"),
    GERENCIAR_USUARIOS("Gerenciar Usuários"),
    VER_RELATORIOS("Ver Relatórios");
    
    private String descricao;
    
    Permission(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
