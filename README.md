# Starter Kit - Projeto APOO

Este é o esqueleto base para o projeto da disciplina de Análise e Projeto Orientado a Objetos.

## Estrutura de Pastas
- **src/br/com/unicesumar/**
  - **model/**: 
    ├── Produto.java          ← Arquivo = Classe "Produto"
    ├── Usuario.java          ← Arquivo = Classe "Usuario"
    ├── Administrador.java    ← Arquivo = Classe "Administrador"
    ├── AlertaEstoque.java    ← Arquivo = Classe "AlertaEstoque"
    ├── Categoria.java        ← Arquivo = Classe "Categoria"
    ├── Funcionario.java      ← Arquivo = Classe "Funcionario"
    ├── Relatorio.java        ← Arquivo = Classe "Relatorio"
    └── Movimentacao.java     ← Arquivo = Classe "Movimentacao"
  - **view/**: Coloque aqui suas Classes de Tela/Console.
  - **controller/**:
    ├── ProdutoController.java        ← Arquivo = Classe "ProdutoController"
    ├── UsuarioController.java        ← Arquivo = Classe "UsuarioController"
    └── MovimentacaoController.java   ← Arquivo = Classe "MovimentacaoController"
  - **Main.java**:  - **[src/br/com/unicesumar/Main.java](src/br/com/unicesumar/Main.java)**

## Funcionalidades Implementadas

### Gestão de Produtos
- ✅ Adicionar, buscar, atualizar e desativar produtos
- ✅ Controlar estoque mínimo
- ✅ Listar produtos ativos

### Gestão de Usuários
- ✅ Registrar usuários
- ✅ Login e logout
- ✅ Gerenciar informações de usuário

### Movimentações de Estoque
- ✅ Registrar entradas de produtos
- ✅ Registrar saídas de produtos
- ✅ Histórico e relatório de movimentações

## Como Rodar

### Opção 1: Via VS Code
1. Abra a pasta raiz no VS Code
2. Abra [src/br/com/unicesumar/Main.java](src/br/com/unicesumar/Main.java)
3. Clique em 'Run' ou pressione Ctrl+F5

### Opção 2: Via Terminal
```bash
# Compilar
javac -encoding UTF-8 -d bin src/br/com/unicesumar/*.java src/br/com/unicesumar/model/*.java src/br/com/unicesumar/controller/*.java

# Executar
java -cp bin br.com.unicesumar.Main