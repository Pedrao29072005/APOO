package br.com.unicesumar;
import br.com.unicesumar.model.Produto;
public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Teclado Gamer");
        produto.setPreco(199.90);
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Preço: R$" + produto.getPreco());
        System.out.println("Sistema Iniciado com Sucesso!");
        System.out.println("Estrutura de pastas carregada.");
    }
}
