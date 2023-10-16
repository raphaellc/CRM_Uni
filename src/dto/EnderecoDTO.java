package dto;

public class EnderecoDTO {

    private Long id_endereco;
    private String cidade;
    private String uf;

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(final Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(final String uf) {
        this.uf = uf;
    }
}
