package VO;

public class Carrinho {

    private Integer id_carrinho;
    private Integer id_produto;
    private Integer id_cliente;
    private Integer itens_qtds;

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

    public Integer getItens_qtds() {
        return itens_qtds;
    }

    public void setItens_qtds(Integer itens_qtds) {
        this.itens_qtds = itens_qtds;
    }
    
    
    
}
