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
}
