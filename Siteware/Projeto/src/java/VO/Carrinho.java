package VO;

public class Carrinho {

    private Integer id_carrinho;
    private Integer id_produto;
    private String produtoNome;
    private Double produtoValor;
    private Integer id_cliente;
    private Integer itens_qtd;
    private Double valorTotalCarrinho;

    public Integer getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(Integer id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getItens_qtd() {
        return itens_qtd;
    }

    public void setItens_qtd(Integer itens_qtd) {
        this.itens_qtd = itens_qtd;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(Double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public Double getValorTotalCarrinho() {
        return valorTotalCarrinho;
    }

    public void setValorTotalCarrinho(Double valorTotalCarrinho) {
        this.valorTotalCarrinho = valorTotalCarrinho;
    }
    
    
    
}
