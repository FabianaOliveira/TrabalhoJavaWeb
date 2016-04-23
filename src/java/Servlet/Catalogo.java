package Servlet;

import Negocio.Produto;
import PACOTEDAO.ImplDAO;
import PACOTEDAO.JavaWebException;
import PACOTEDAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Catalogo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // Obtencao do canal de envio de dados para o cliente
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Catalogo Produtos - Fabi.com</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<H3>Catalogo de produtos </H3>");
        // Inicio da tabela de produtos
        out.println("<TABLE width = '700' border='0'>");

        //Linha de titulo
        out.println("<TR width = '%100' class='tituloCampo'>");
        out.println("<TD width = '%20'  >Imagem</TD>");
        out.println("<TD width = '%10' >Nome</TD>");
        out.println("<TD width = '%10' >Codigo</TD>");
        out.println("<TD width = '%10' >Descri&ccedil;&atilde;o</TD>");
        out.println("<TD width = '%10' >Pre&ccedil;o</TD>");
        out.println("<TD width = '%20' colspan = '2'>Comprar</TD>");
        out.println("</TR>");
        

        // -------------------------------------------------------------------
        // Insira a partir daqui o codigo pedido no laboratorio:
        // -------------------------------------------------------------------
        ProdutoDAO banco = new ImplDAO();
        try {
            List<Produto> listaProdutos = banco.getCatalogoProdutos();

            for (Produto prod : listaProdutos) {

                out.println("<TR width = '%100'>");
                out.println("<TD width = '%20'> <IMG SRC = 'imagem/" + prod.getImage() + "'/></TD>");
                out.println("<TD width = '%10'  class='gridCampo'>"+ prod.getNome() +"</TD>");
                out.println("<TD width = '%10' class='gridCampo'>"+ prod.getCodigo() + "</TD>");
                out.println("<TD width = '%10'  class='gridCampo'>" + prod.getDescricao() + "</TD>");
                out.println("<TD width = '%10' class='gridCampo'>"+ prod.getPreco()+ "</TD>");
                out.println("<TD width = '%20' colspan = '2'><A HREF= 'cesta?idProduto=" + prod.getId()+"' ><IMG SRC = 'imagem/carrinho.jpg'/></A></TD>");
                out.println("</TR>");
            }
            } catch (JavaWebException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
         // final da tabela de produtos
        out.println("</TABLE>");
        out.println("<a href=\"logout\">Clique aqui para sair do sistema</a>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }
}
