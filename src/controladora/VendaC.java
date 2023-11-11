package controladora;

import java.util.Date;

public class VendaC {

    private String vendedor;
    private double valor;
    private double desconto;
    private boolean fechada;
    private Date dataInicio;
    private Date dataFinalizacao;
    private int quantidadeProdutos;

    public VendaC(String vendedor, double valor, double desconto, Date dataFinalizacao, int quantidadeProdutos) {
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public long calcularTempoVenda() {
        if (dataFinalizacao != null) {
            // Calcula a diferença em milissegundos
            long diferencaEmMilissegundos = dataFinalizacao.getTime() - dataInicio.getTime();
            // Converte para dias (1 dia = 24 horas * 60 minutos * 60 segundos * 1000 milissegundos)
            long tempoEmDias = diferencaEmMilissegundos / (24 * 60 * 60 * 1000);
            return tempoEmDias;
        } else {
            // Venda não foi finalizada
            return -1;
        }
    }

}
