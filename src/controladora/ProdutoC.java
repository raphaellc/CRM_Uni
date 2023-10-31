package src.controladora;

import java.util.ArrayList;
import java.util.List;
public class ProdutoC {
    private String nome;
    private double valor;
    private int fluxoSaidaProd;

    public ProdutoC(String nome, double valor, int fluxoSaidaProd) {
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
}
