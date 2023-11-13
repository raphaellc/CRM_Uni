package src.modelo;

public class ProdutoModelo {
    private String nome;
    private double valor;
    private int fluxoSaidaProd;

    public ProdutoModelo(String nome, double valor, int fluxoSaidaProd) {
        this.nome = nome;
        this.valor = valor;
        this.fluxoSaidaProd = fluxoSaidaProd;
    }

    public void armazenarDadosProduto() {
        System.out.println("Dados do produto armazenados: " + nome);
    }

    public int getFluxoSaidaProd() {
        return fluxoSaidaProd;
    }

    public int adicionaFluxoSaidaProd(int quantidadeProdutos, int fluxoSaidaProd) {
        fluxoSaidaProd += quantidadeProdutos;
        return fluxoSaidaProd;
    }
}
/**
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

    public void setFluxoSaidaProd(int fluxoSaidaProd) {
        this.fluxoSaidaProd = fluxoSaidaProd;
    }
}

**/