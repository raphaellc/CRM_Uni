package src.modelo;

import java.util.ArrayList;
import java.util.List;

class AnaliseVendasModelo {
    private List<ProdutoModelo> produtos;

    public void AnaliseDeVenda(List<ProdutoModelo> produtos) {
        this.produtos = produtos;
    }
    //método que gera o produto mais vendido
    public ProdutoModelo getProdutoComMaiorFluxoDeSaida() {
        if (produtos == null || produtos.isEmpty()) {
            return null;
        }

        ProdutoModelo produtoComMaiorFluxo = produtos.get(0);

        for (ProdutoModelo produto : produtos) {
            if (produto.getFluxoSaidaProd() > produtoComMaiorFluxo.getFluxoSaidaProd()) {
                produtoComMaiorFluxo = produto;
            }
        }

        return produtoComMaiorFluxo;
    }
}
    public void gerarRelatorioVendas() {
        System.out.println("Relatório de Vendas:");
        for (VendaC venda : dadosVenda) {
            System.out.println("Vendedor: " + venda.getVendedor());
            System.out.println("Cliente: " + venda.getCliente());
            System.out.println("Valor da Venda: " + venda.getValorVenda());
            System.out.println("Quantidade de Produtos: " + venda.getQtdProduto());
            System.out.println("Data de Finalização da Venda: " + venda.getDataFinalizacaoVenda());
            System.out.println("-------------------------");
        }
    }
}
