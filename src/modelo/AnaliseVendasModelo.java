package src.modelo;

import src.dto.ProdutoDto;
import java.util.List;

class AnaliseVendasModelo {
    private List<ProdutoDto> lista_de_produtos;

    public void AnaliseDeVenda(List<ProdutoDto> lista_de_produtos) {
        this.lista_de_produtos = lista_de_produtos;
    }
    //método que retorna o produto mais vendido
    public ProdutoDto getProdutoComMaiorFluxoDeSaida() {
        if (lista_de_produtos == null || lista_de_produtos.isEmpty()) {
            return null;
        }

        ProdutoDto produtoComMaiorFluxo = lista_de_produtos.get(0);

        for (ProdutoDto produto : lista_de_produtos) {
            if (produto.getFluxoSaidaProd() > produtoComMaiorFluxo.getFluxoSaidaProd()) {
                produtoComMaiorFluxo = produto;
            }
        }

        return produtoComMaiorFluxo;
    }

    //Método para verificar o produto com o maior valor:
    public ProdutoDto identificaMaiorValor(List<ProdutoDto> lista_de_produtos) {
        if (lista_de_produtos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        ProdutoDto produto_maior_valor = lista_de_produtos.get(0);

        for (ProdutoDto produto : lista_de_produtos) {
            if (produto.getValor() >= produto_maior_valor.getValor()) {
                produto_maior_valor = produto;
            }
        }
        return produto_maior_valor;
    }
    
    //Método para verificar o produto com o maior valor:
    public ProdutoDto identificaMenorValor(List<ProdutoDto> lista_de_produtos) {
        if (lista_de_produtos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        ProdutoDto produto_menor_valor = lista_de_produtos.get(0);

        for (ProdutoDto produto : lista_de_produtos) {
            if (produto.getValor() <= produto_menor_valor.getValor()) {
                produto_menor_valor = produto;
            }
        }
        return produto_menor_valor;
    }
}
