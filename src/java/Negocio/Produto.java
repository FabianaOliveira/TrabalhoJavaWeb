package Negocio;

public class Produto {

    private String nome;
    private String codigo;
    private String descricao;
    private double preco;
    private String image;
    private int id;

    public String getCodigo() {
        return codigo;
    }

    public Produto(String nome, String codigo, String desc, double preco, String image) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = desc;
        this.preco = preco;
        this.image = image;
    }

    public Produto(int id, String nome, String codigo, String desc, double preco, String image) {
        this(nome, codigo, desc, preco, image);
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    @Override
    public String toString() {
        String pNome = " Nome     :" + nome + "\n";
        String pId = " ID    :" + id + "\n";
        String pDesc = " Descricao:" + descricao + "\n";
        String pPreco = " Preco    :" + preco + "\n";
        String pCodigo = " Codigo   :" + codigo + "\n";
        String pImage = " Imagem    :" + image + "\n";
        String dados = pNome + pId + pCodigo + pImage + pDesc + pPreco + "\n";
        return dados;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Produto) {
            Produto oProduto = (Produto) o;
            return this.id == oProduto.id;
        } else
            return false;
    }

}