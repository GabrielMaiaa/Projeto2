package VO;

import javax.servlet.http.Part;

public class Produtos {
    private Integer idProduto;
    private String nome;
    private Double valor;
    private Integer idPromocao;
    private Part imagem;
    private String nomeArquivo;

    // Construtor vazio
    public Produtos() {
    }

    // Construtor com todos os parâmetros
    public Produtos(Integer idProduto, String nome, Double valor, Integer idPromocao, Part imagem,String nomeArquivo) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.idPromocao = idPromocao;
        this.imagem = imagem;
        this.nomeArquivo = nomeArquivo;
    }

    // Getters e setters
    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        if (valor != null && valor >= 0) {
            this.valor = valor;
        } else {
            // Lançar uma exceção ou fazer outro tratamento de erro
            throw new IllegalArgumentException("Valor inválido");
        }
    }

    public Integer getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(Integer idPromocao) {
        this.idPromocao = idPromocao;
    }

    public Part getImagem() {
        return imagem;
    }

    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    
}
