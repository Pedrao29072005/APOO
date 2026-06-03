# Sistema de Estoque Interativo - Guia de Uso

## ✅ O Que Foi Implementado

Seu projeto agora possui um **sistema completo de entrada de dados com controle de permissões**, sem quebrar o núcleo da aplicação!

### 1. **Sistema de Permissões**
- Arquivo: `Permission.java` - Enum com 6 permissões diferentes
- Integrado em: `Usuario.java` - Todos os usuários possuem um conjunto de permissões

### 2. **Tipos de Usuários com Permissões Pré-Definidas**

#### Administrador
- ✓ Criar Produtos
- ✓ Editar Produtos  
- ✓ Deletar Produtos
- ✓ Registrar Movimentação
- ✓ Gerenciar Usuários
- ✓ Ver Relatórios

#### Funcionário
- ✓ Registrar Movimentação
- ✓ Ver Relatórios

#### Usuário Padrão
- ✓ Ver Relatórios

### 3. **Interface Interativa - ConsoleView**
Implementação completa com:
- Menu de login/registro
- Menu principal com opções baseadas em permissões
- Submenu para gerenciar produtos
- Submenu para movimentações de estoque
- Visualização de relatórios
- Gerenciamento de usuários (apenas admin)
- Validação em tempo real de permissões

### 4. **Controllers Atualizados**
- **UsuarioController**: 
  - `registrarUsuarioComTipo()` - Criar usuários com tipo específico
  - `listarUsuarios()` - Listar todos os usuários do sistema

---

## 🚀 Como Usar

### Compilação
```bash
cd "seu_caminho\APOO"
javac -encoding UTF-8 -d bin src/br/com/unicesumar/*.java src/br/com/unicesumar/model/*.java src/br/com/unicesumar/controller/*.java src/br/com/unicesumar/view/*.java
```

### Execução
```bash
java -cp bin br.com.unicesumar.Main
```

---

## 📋 Fluxo de Uso

### 1. Primeira Execução - Criar Usuários

```
========== LOGIN / REGISTRO ==========
1. Fazer Login
2. Criar Novo Usuário
0. Sair
```

Escolha **opção 2** e siga as instruções:

```
Nome: João Silva
Login: joao
Email: joao@empresa.com
Senha: 123456

Tipo de Usuário:
1. Administrador
2. Funcionário
3. Usuário Padrão
Escolha o tipo: 1
```

### 2. Login
Volte ao menu e escolha **opção 1** para fazer login com o usuário criado

```
Login: joao
Senha: 123456
✓ Login realizado com sucesso!
```

### 3. Menu Principal
Após login, você terá acesso a opções baseadas em suas permissões:

```
========== MENU PRINCIPAL - João Silva ==========
1. Gerenciar Produtos
2. Registrar Movimentação de Estoque
3. Ver Relatórios
4. Gerenciar Usuários
5. Minhas Permissões
0. Logout
```

### 4. Adicionar Produtos (apenas com permissão CRIAR_PRODUTOS)

```
========== GERENCIAR PRODUTOS ==========
1. Adicionar Novo Produto
2. Listar Produtos
3. Atualizar Produto
4. Deletar Produto
0. Voltar

--- Adicionar Novo Produto ---
Nome do Produto: Notebook
Descrição: Notebook Dell XPS
Quantidade inicial: 10
Preço (R$): 3500.00
Estoque mínimo: 5
Unidade (ex: unidade, kg, litro): unidade
```

### 5. Registrar Movimentação (apenas com permissão REGISTRAR_MOVIMENTACAO)

```
========== REGISTRAR MOVIMENTAÇÃO ==========
1. Entrada de Estoque
2. Saída de Estoque
0. Voltar

--- Entrada de Estoque ---
ID do produto: 1
Quantidade: 5
Observação: Compra fornecedor
```

### 6. Ver Relatórios (qualquer usuário pode)

```
========== RELATÓRIOS ==========
1. Produtos com Estoque Baixo
2. Valor Total do Estoque
3. Histórico de Movimentações
0. Voltar
```

### 7. Minhas Permissões
Visualize as permissões do usuário logado:

```
========== MINHAS PERMISSÕES ==========
Usuário: João Silva
Tipo: Administrador

Permissões:
  ✓ Criar Produtos
  ✓ Editar Produtos
  ✓ Deletar Produtos
  ✓ Registrar Movimentação
  ✓ Gerenciar Usuários
  ✓ Ver Relatórios
```

---

## 🔒 Validação de Permissões

Se um usuário (não-administrador) tentar acessar uma função sem permissão:

```
========== MENU PRINCIPAL - Maria Santos ==========
1. Gerenciar Produtos
...

Escolha uma opção: 1

❌ Acesso negado! Você não tem permissão para gerenciar produtos.
```

---

## 📁 Estrutura de Arquivos Criados/Modificados

### Criados:
- `src/br/com/unicesumar/model/Permission.java` - Sistema de permissões

### Modificados:
- `src/br/com/unicesumar/model/Usuario.java` - Adicionado suporte a permissões
- `src/br/com/unicesumar/model/Administrador.java` - Permissões de admin
- `src/br/com/unicesumar/model/Funcionario.java` - Permissões de funcionário  
- `src/br/com/unicesumar/model/UsuarioPadrao.java` - Permissões básicas
- `src/br/com/unicesumar/view/ConsoleView.java` - Interface completa
- `src/br/com/unicesumar/controller/UsuarioController.java` - Novos métodos
- `src/br/com/unicesumar/Main.java` - Inicia ConsoleView

---

## 🎯 Diferenciais do Sistema

✅ **Sem quebra do núcleo** - Todas as mudanças foram adições, não modificações
✅ **Arquitetura em camadas** - Separação clara entre Model, Controller, View
✅ **Sistema de permissões robusto** - Validação em tempo de execução
✅ **Interface amigável** - Menus intuitivos e mensagens claras
✅ **Tratamento de erros** - Validação de entrada e acesso
✅ **Polimorfismo** - Diferentes tipos de usuários com permissões específicas

---

## 💡 Próximas Melhorias (Sugestões)

1. Persistência em banco de dados (Database)
2. Autenticação com hash de senha
3. Log de operações (auditoria)
4. Relatórios mais detalhados
5. Interface gráfica (Swing/JavaFX)
6. Backup e restore de dados

---

**Desenvolvido com padrões OOP (Herança, Polimorfismo, Encapsulamento) e SOLID**
