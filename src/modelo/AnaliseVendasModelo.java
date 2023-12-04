package src.modelo;

import src.dto.AnaliseVendasDto;
import src.dao.AnaliseVendasDao;
import src.dao.Conexao;
import java.util.List;

public class AnaliseVendasModelo {


    private AnaliseVendasDao analise_vendas_dao;
    private Conexao conexao;
    private List<AnaliseVendasDto> lista_de_produtos;

    public AnaliseVendasModelo(){
        AnaliseVendasDao analise_vendas_dao = new AnaliseVendasDao();
        AnaliseVendasDao lista_de_produtos = new AnaliseVendasDao();
    }

    public void AnaliseDeVenda(List<AnaliseVendasDto> lista_de_produtos) {
        this.lista_de_produtos = lista_de_produtos;
    }
    //método que retorna o produto mais vendido
    public AnaliseVendasDto identificaProdutoMaisVendido() {
        if (lista_de_produtos == null || lista_de_produtos.isEmpty()) {
            return null;
        }

        AnaliseVendasDto produto_mais_vendido = lista_de_produtos.get(0);

        for (AnaliseVendasDto produto : lista_de_produtos) {
            if (produto.getQtd_vendas_produto() > produto_mais_vendido.getQtd_vendas_produto()) {
                produto_mais_vendido = produto;
            }
        }

        return produto_mais_vendido;
    }

    //Método para verificar o produto com o maior valor:
    public AnaliseVendasDto identificaProdutoMaiorValor(List<AnaliseVendasDto> lista_de_produtos) {
        if (lista_de_produtos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        AnaliseVendasDto produto_maior_valor = lista_de_produtos.get(0);

        for (AnaliseVendasDto produto : lista_de_produtos) {
            if (produto.getValorProduto() >= produto_maior_valor.getValorProduto()) {
                produto_maior_valor = produto;
            }
        }
        return produto_maior_valor;
    }
    
    //Método para verificar o produto com o menor valor:
    public AnaliseVendasDto identificaProdutoMenorValor(List<AnaliseVendasDto> lista_de_produtos) {
        if (lista_de_produtos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        AnaliseVendasDto produto_menor_valor = lista_de_produtos.get(0);

        for (AnaliseVendasDto produto : lista_de_produtos) {
            if (produto.getValorProduto() <= produto_menor_valor.getValorProduto()) {
                produto_menor_valor = produto;
            }
        }
        return produto_menor_valor;
    }

    public List<AnaliseVendasDto> listarVendas() {
        return (List<AnaliseVendasDto>) analise_vendas_dao.listarVendas();
    }

}
