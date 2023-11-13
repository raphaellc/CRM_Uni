package src.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import src.dto.ProdutoDto;

public class VendaModelo {

    private String nomeCliente;
    private String vendedor;
    private double valor;
    private double desconto;
    private boolean fechada;
    private Date dataFinalizacao;
    private int quantidadeProdutos;

    public VendaModelo() {

    }

    public VendaModelo(String vendedor, double valor, double desconto, Date dataFinalizacao, int quantidadeProdutos) {
        this.vendedor = vendedor;
        this.valor = valor;
        this.desconto = desconto;
        this.fechada = false;
        this.dataFinalizacao = null;
        this.quantidadeProdutos = quantidadeProdutos;
    }
    List<ProdutoDto> lista_de_produtos = new ArrayList<>();

    //Método para verificar o produto com o maior valor:
    public ProdutoDto identificaMaiorValor(List<ProdutoDto> lista_de_produtos) {
        if (lista_de_produtos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        ProdutoDto produto_maior_valor = lista_de_produtos.get(0);

        for (ProdutoDto produto : lista_de_produtos) {
            if (produto.getValor() > produto_maior_valor.getValor()) {
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
            if (produto.getValor() < produto_menor_valor.getValor()) {
                produto_menor_valor = produto;
            }
        }
        return produto_menor_valor;
    }
}
