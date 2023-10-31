package src.controladora;
import java.util.ArrayList;
import java.util.List;

class VendaC {
    private String vendedor;
    private String cliente;
    private double valorVenda;
    private int qtdProduto;
    private int periodoTempoVenda;
    private String dataFinalizacaoVenda;

    public VendaC(String vendedor, String cliente, double valorVenda, int qtdProduto, int periodoTempoVenda, String dataFinalizacaoVenda) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.valorVenda = valorVenda;
        this.qtdProduto = qtdProduto;
        this.periodoTempoVenda = periodoTempoVenda;
        this.dataFinalizacaoVenda = dataFinalizacaoVenda;
    }

    public void armazenarDadosVendas() {
        System.out.println("Dados da venda armazenados: " + vendedor);
    }

    public List<ProdutoC> filtrarProdutos(List<ProdutoC> produtos, int fluxoSaidaDesejado) {
        List<ProdutoC> produtosFiltrados = new ArrayList<>();
        return produtosFiltrados;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public int getPeriodoTempoVenda() {
        return periodoTempoVenda;
    }

    public String getDataFinalizacaoVenda() {
        return dataFinalizacaoVenda;
    }
}
