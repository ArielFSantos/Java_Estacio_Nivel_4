package cadastroee.servlets;


import cadastroee.servlets.MeuServlet.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**/public class ProdutoController extends HttpServlet {

    @EJB
    ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao;
        acao = request.getParameter("acao");
        String destino = "";

        if (null != acao) switch (acao) {
            case "listar" ->                 {
                Object produtos = null;
                
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
            }
            
            
            case "formAlterar" ->                 {
                int id = Integer.parseInt(request.getParameter("id"));
                Produto produto = facade.getProduto(id);
                request.setAttribute("produto", produto);
                destino = "ProdutoDados.jsp";
            }
            case "excluir" ->                 {
                int id = Integer.parseInt(request.getParameter("id"));
                facade.removerProduto(id);
                /*                    List<Produto> produtos = facade.listarProdutos();*/                   Object produtos = null;
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
            }
            
            case "alterar" ->                 {
                Object produtos = null;
                // Preencher os campos com valores do request
                // Alterar os dados do produto via facade
                
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
            }
            
            
            
            case "incluir" ->                 {
                Produto produto = new Produto();
                // Preencher os campos com valores do request
                facade.inserirProduto(produto);
                
                destino = "ProdutoLista.jsp";
            }
            
            default -> // Ação desconhecida
                destino = "paginaDeErro.jsp";
        } else {
            // Ação desconhecida
            destino = "paginaDeErro.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

    // ... Outros métodos do servlet, se houverem

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
