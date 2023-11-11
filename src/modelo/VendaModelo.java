package src.modelo;

import java.util.Date;

public class VendaModelo {

    private String nomeCliente;
    private String vendedor;
    private double valor;
    private double desconto;
    private boolean fechada;
    private Date dataFinalizacao;
    private int quantidadeProdutos;

    public VendaModelo(String vendedor, double valor, double desconto, Date dataFinalizacao, int quantidadeProdutos) {
        this.vendedor = vendedor;
        this.valor = valor;
        this.desconto = desconto;
        this.fechada = false;
        this.dataFinalizacao = null;
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public void fecharVenda() {
        this.fechada = true;
        this.dataFinalizacao = new Date();
    }

    public String getVendedor() {
        return vendedor;
    }

    public double getValor() {
        return valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public boolean isFechada() {
        return fechada;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

}
