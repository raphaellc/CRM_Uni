package dto;

public class StatusPessoaDTO {
    private int idStatusPessoa;
    private String descricao;

    // Construtores, getters e setters

    public StatusPessoaDTO(int idStatusPessoa, String descricao) {
        this.idStatusPessoa = idStatusPessoa;
        this.descricao = descricao;
    }

    public int getIdStatusPessoa() {
        return idStatusPessoa;
    }

    public void setIdStatusPessoa(int idStatusPessoa) {
        this.idStatusPessoa = idStatusPessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}