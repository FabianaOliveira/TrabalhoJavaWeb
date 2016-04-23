package PACOTEDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import Negocio.Produto;

public class ImplDAO implements ProdutoDAO {

    private final String INSERT_QUERY = "insert into produtos (nome,codigo,preco,descricao,image) values (?,?,?,?,?)";
    private final String SELECT_ALL_QUERY = "select * from produtos";
    private final String SELECT_BY_ID_QUERY = "select * from produtos where id = ? ";
    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS produtos ( nome varchar(50) default NULL, codigo varchar(50) default NULL,  preco float(50,0) default NULL,`descricao` varchar(50) default NULL,image varchar(50) default NULL,id smallint NOT NULL auto_increment,PRIMARY KEY  (id))";

    @Override
    public void save(Produto p) throws JavaWebException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Conecta.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setString(1, p.getNome());
            prepStmt.setString(2, p.getCodigo());
            prepStmt.setDouble(3, p.getPreco());
            prepStmt.setString(4, p.getDescricao());
            prepStmt.setString(5, p.getImage());
            prepStmt.execute();
        } catch (SQLException e) {
            String msg = "[ProdutosDB][save(Produto p)]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            Conecta.closeAll(conn, prepStmt, rs);
        }
    }

    @Override
    public List<Produto> getCatalogoProdutos() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Produto> listaProdutos = new ArrayList<Produto>();
        try {
            conn = Conecta.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_QUERY);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                String descricao = rs.getString("descricao");
                String imagem = rs.getString("image");
                double preco = rs.getFloat("preco");
                Produto p = new Produto(id, nome, codigo, descricao, preco, imagem);
                listaProdutos.add(p);
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getCatalogoProdutos()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            Conecta.closeAll(conn, stmt, rs);
        }
        return listaProdutos;
    }

    @Override
    public Produto getProdutoById(int id) throws JavaWebException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Produto oProduto = null;
        try {
            conn = Conecta.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
            prepStmt.setInt(1, id);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                String descricao = rs.getString("descricao");
                String imagem = rs.getString("image");
                double preco = rs.getFloat("preco");
                oProduto = new Produto(id, nome, codigo, descricao, preco, imagem);
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            Conecta.closeAll(conn, prepStmt, rs);
        }
        return oProduto;
    }

    @Override
    public void createTable() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        try {

            conn = Conecta.getConexao();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE);

            Produto[] produtos = {
                new Produto(86, "Floratta in Rose", "Floratta", "Desodorante Colonia 100ml", 80, "Floratta.jpg"),
                new Produto(85, "Accordes", "accordes", "Desodorante Colonia 80ml", 18, "accordes.jpg"),
                new Produto(82, "Egeo Dolce", "egeo", "Desodorante Colonia 100ml", 1750, "egeo.jpg"),
                new Produto(83, "Malbec", "malbec", "Desodorante Colonia 100ml", 13, "malbec.jpg"),
                new Produto(79, "Quasar", "quasar", "Desodorante Colonia 100ml", 15, "quasar.jpg")
            };

            String insertComId = "insert into produtos (nome,codigo,preco,descricao,image,id) values (?,?,?,?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(insertComId);
            for (int i = 0; i < produtos.length; i++) {
                Produto p = produtos[i];
                prepStmt.setString(1, p.getNome());
                prepStmt.setString(2, p.getCodigo());
                prepStmt.setDouble(3, p.getPreco());
                prepStmt.setString(4, p.getDescricao());
                prepStmt.setString(5, p.getImage());
                prepStmt.setInt(6, p.getId());
                prepStmt.execute();
                prepStmt.clearParameters();
            }
            prepStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new JavaWebException("Erro ao criar a tabela de produtos", e);
        } finally {
            Conecta.closeAll(conn, stmt);
        }
    }
}
