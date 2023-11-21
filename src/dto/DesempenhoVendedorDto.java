package src.dto;

public class DesempenhoVendedorDto {
    private int id_vendedor;
    private String nome_vendedor;
    private int nmro_vendas;


    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public int getNmro_vendas() {
        return nmro_vendas;
    }

    public void setNmro_vendas(int nmro_vendas) {
        this.nmro_vendas = nmro_vendas;
    }
}
