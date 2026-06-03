package br.com.unicesumar.model;

public class UsuarioPadrao extends Usuario {
    
    @Override
    public void executarAcao() {
        System.out.println("   [USUÁRIO] Executando ações padrão do sistema");
    }
}
