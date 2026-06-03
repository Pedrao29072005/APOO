package br.com.unicesumar;

import br.com.unicesumar.controller.ProdutoController;
import br.com.unicesumar.controller.UsuarioController;
import br.com.unicesumar.controller.MovimentacaoController;
import br.com.unicesumar.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        // Inicializar controllers
        ProdutoController produtoCtrl = new ProdutoController();
        UsuarioController usuarioCtrl = new UsuarioController();
        MovimentacaoController movimentacaoCtrl = new MovimentacaoController(produtoCtrl);
        
        // Iniciar a interface interativa
        ConsoleView view = new ConsoleView(usuarioCtrl, produtoCtrl, movimentacaoCtrl);
        view.iniciar();
    }
}
