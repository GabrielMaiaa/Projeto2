package VO;

public class Promocao { 
    
	private Integer idPromocao;
	private String nomePromocao;
        private int quantidadeComprar;
        private Double precoPagar;
                
        
    public Integer getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(Integer idPromocao) {
        this.idPromocao = idPromocao;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public int getQuantidadeComprar() {
        return quantidadeComprar;
    }

    public void setQuantidadeComprar(int quantidadeComprar) {
        this.quantidadeComprar = quantidadeComprar;
    }

    public Double getPrecoPagar() {
        return precoPagar;
    }

    public void setPrecoPagar(Double precoPagar) {
        this.precoPagar = precoPagar;
    }


}
