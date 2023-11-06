import java.util.List;

public class RelatorioDesempenhoVendasC {
    private EquipeVendasC equipeVendas;

    public RelatorioDesempenhoVendasC(EquipeVendasC equipeVendas) {
        this.equipeVendas = equipeVendas;
    }

    public double calcularValorTotalVendas() {
        double totalVendas = 0;

        for (VendaC venda : equipeVendas.getVendas()) {
            if (venda.isFechada()) {
                totalVendas += venda.getValor();
            }
        }

        return totalVendas;
    }

    public String gerarRelatorioGeral() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório Geral de Vendas:\n");

        for (VendaC venda : equipeVendas.getVendas()) {
            relatorio.append("Vendedor: " + venda.getVendedor() + "\n");
            relatorio.append("Valor da Venda: " + venda.getValor() + "\n");
            relatorio.append("Desconto: " + venda.getDesconto() + "\n");
            relatorio.append("Quantidade de Produtos: " + venda.getQuantidadeProdutos() + "\n");
            relatorio.append("Data de Início: " + venda.getDataInicio() + "\n");
            relatorio.append("Data de Finalização: " + venda.getDataFinalizacao() + "\n");
            relatorio.append("Tempo para Venda (dias): " + venda.calcularTempoVenda() + "\n");
            relatorio.append("\n");
        }

        return relatorio.toString();
    }

    public long calcularTempoNecessarioParaVenda(VendaC venda) {
        return venda.calcularTempoVenda();
    }
}