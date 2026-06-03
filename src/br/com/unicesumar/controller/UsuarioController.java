package br.com.unicesumar.controller;

import br.com.unicesumar.model.Usuario;
import br.com.unicesumar.model.UsuarioPadrao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioController {
    private List<Usuario> usuarios;
    private int proximoId = 1;
    private Usuario usuarioLogado;
    
    public UsuarioController() {
        this.usuarios = new ArrayList<>();
        this.usuarioLogado = null;
    }
    
    // CREATE - Registrar novo usuário
    public boolean registrarUsuario(String nome, String login, String email, String senha) {
        if (login == null || login.trim().isEmpty()) {
            System.out.println("Erro: Login não pode estar vazio!");
            return false;
        }
        
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Erro: Email não pode estar vazio!");
            return false;
        }
        
        // Verificar se login já existe
        Optional<Usuario> usuarioExistente = usuarios.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
        
        if (usuarioExistente.isPresent()) {
            System.out.println("Erro: Login já existe!");
            return false;
        }
        
        Usuario novoUsuario = new UsuarioPadrao();
        novoUsuario.setId(proximoId++);
        novoUsuario.setNome(nome);
        novoUsuario.setLogin(login);
        novoUsuario.setSenha(senha);
        novoUsuario.setEmail(email);
        novoUsuario.setAtivo(true);
        usuarios.add(novoUsuario);
        System.out.println("✓ Usuário '" + nome + "' registrado com sucesso!");
        return true;
    }
    
    // LOGIN - Autenticar usuário
    public boolean login(String login, String senha) {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getLogin().equals(login) && u.getSenha().equals(senha))
                .findFirst();
        
        if (usuario.isPresent()) {
            usuarioLogado = usuario.get();
            System.out.println("✓ Login realizado com sucesso! Bem-vindo " + usuario.get().getNome() + "!");
            return true;
        }
        
        System.out.println("Erro: Login ou senha inválidos!");
        return false;
    }
    
    // LOGOUT - Desconectar usuário
    public boolean logout() {
        if (usuarioLogado != null) {
            System.out.println("✓ " + usuarioLogado.getNome() + " desconectado com sucesso!");
            usuarioLogado = null;
            return true;
        }
        System.out.println("Erro: Nenhum usuário logado!");
        return false;
    }
    
    // READ - Buscar usuário por ID
    public Usuario buscarPorId(int id) {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        
        if (usuario.isPresent()) {
            return usuario.get();
        }
        System.out.println("Erro: Usuário com ID " + id + " não encontrado!");
        return null;
    }
    
    // READ - Buscar usuário por login
    public Usuario buscarPorLogin(String login) {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
        
        if (usuario.isPresent()) {
            return usuario.get();
        }
        System.out.println("Erro: Usuário com login '" + login + "' não encontrado!");
        return null;
    }
    
    // UPDATE - Atualizar informações do usuário
    public boolean atualizarUsuario(int id, String nome, String email) {
        Usuario usuario = buscarPorId(id);
        
        if (usuario == null) {
            return false;
        }
        
        usuario.setNome(nome);
        usuario.setEmail(email);
        System.out.println("✓ Usuário atualizado com sucesso!");
        return true;
    }
    
    // DELETE - Desativar usuário
    public boolean desativarUsuario(int id) {
        Usuario usuario = buscarPorId(id);
        
        if (usuario == null) {
            return false;
        }
        
        usuario.setAtivo(false);
        System.out.println("✓ Usuário desativado com sucesso!");
        return true;
    }
    
    // READ - Listar todos os usuários ativos
    public List<Usuario> listarUsuariosAtivos() {
        List<Usuario> ativos = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.isAtivo()) {
                ativos.add(u);
            }
        }
        return ativos;
    }
    
    // Listar todos
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
    
    // Verificar se há usuário logado
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
