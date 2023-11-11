package controladora;

import java.util.ArrayList;
import java.util.List;

class RelatorioVendaC {
    private List<VendaC> dadosVenda;

    public RelatorioVendaC() {
        this.dadosVenda = new ArrayList<>();
    }

    public void adicionarVenda(VendaC venda) {
        dadosVenda.add(venda);
    }

    public List<VendaC> filtrarConteudo(String vendedor) {
        List<VendaC> vendasFiltradas = new ArrayList<>();
        for (VendaC venda : dadosVenda) {
            if (venda.getVendedor().equals(vendedor)) {
                vendasFiltradas.add(venda);
            }
        }
        return vendasFiltradas;
    }

    public void gerarRelatorioVendas() {
        System.out.println("Relatório de Vendas:");
        for (VendaC venda : dadosVenda) {
            System.out.println("Vendedor: " + venda.getVendedor());
            System.out.println("Cliente: " + venda.getCliente());
            System.out.println("Valor da Venda: " + venda.getValorVenda());
            System.out.println("Quantidade de Produtos: " + venda.getQtdProduto());
            System.out.println("Período de Tempo de Venda: " + venda.getPeriodoTempoVenda());
            System.out.println("Data de Finalização da Venda: " + venda.getDataFinalizacaoVenda());
            System.out.println("-------------------------");
        }
    }
}
