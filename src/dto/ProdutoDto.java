package src.dto;

public class ProdutoDto {
    private String nome;
    private double valor;
    private int fluxoSaidaProd;

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
        return fluxoSaidaProd;
    }

    public void setFluxoSaidaProd(int fluxoSaidaProd) {
        this.fluxoSaidaProd = fluxoSaidaProd;
    }
}
