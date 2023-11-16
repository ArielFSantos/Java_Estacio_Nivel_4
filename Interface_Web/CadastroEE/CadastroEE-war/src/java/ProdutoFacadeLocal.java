import cadastroee.servlets.MeuServlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoFacadeLocal {

    private final Map<Integer, MeuServlet.Produto> produtos;

    public ProdutoFacadeLocal() {
        this.produtos = new HashMap<>();
        // Inicializar alguns produtos para exemplo
        inicializarProdutos();
    }

    private void inicializarProdutos() {
        inserirProduto(new MeuServlet.Produto(1, "Produto 1", 10.0));
        inserirProduto(new MeuServlet.Produto(2, "Produto 2", 20.0));
        inserirProduto(new MeuServlet.Produto(3, "Produto 3", 30.0));
    }

    List<MeuServlet.Produto> listarProdutos() {
        return new ArrayList<>(produtos.values());
    }

    MeuServlet.Produto getProduto(int id) {
        return produtos.get(id);
    }

    void removerProduto(int id) {
        produtos.remove(id);
    }

    void inserirProduto(MeuServlet.Produto produto) {
        produtos.put(produto.getId(), produto);
    }
}
