package src.dto;

public class ProdutoDto {
    private String nome;
    private double valor;
    private int fluxo_saida_prod;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getFluxoSaidaProd() {
        return fluxo_saida_prod;
    }

    public void setFluxoSaidaProd(int fluxo_saida_prod) {
        this.fluxo_saida_prod = fluxo_saida_prod;
    }
}
