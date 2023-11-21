package src.dto;

import java.util.Date;

public class AnaliseVendasDto {
    private int id_venda;
    private int id_vendedor;
    private int id_cliente;
    private double valor_venda;
    private String status;
    private Date data_venda;
    private int quantidade_produtos;

    private double valor_produto;
    private int fluxo_saida_produto;

    public AnaliseVendasDto(){

    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public int getQuantidade_produtos() {
        return quantidade_produtos;
    }

    public void setQuantidade_produtos(int quantidade_produtos) {
        this.quantidade_produtos = quantidade_produtos;
    }

    public double getValorProduto() {
        return valor_produto;
    }

    public void setValorProduto(double valor_produto) {
        this.valor_produto = valor_produto;
    }

    public int getFluxoSaidaProduto() {
        return fluxo_saida_produto;
    }

    public void setFluxoSaidaProduto(int fluxo_saida_produto) {
        this.fluxo_saida_produto = fluxo_saida_produto;
    }

}
