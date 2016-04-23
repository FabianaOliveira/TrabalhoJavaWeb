package PACOTEDAO;
import java.util.List;
import Negocio.Produto;

public interface ProdutoDAO {

    public void save(Produto p) throws JavaWebException;

    public List<Produto> getCatalogoProdutos() throws JavaWebException;

    public Produto getProdutoById(int id) throws JavaWebException;

    public void createTable() throws JavaWebException;
}