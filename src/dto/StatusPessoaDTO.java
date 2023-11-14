public class StatusPessoaDTO {
    private int idStatusPessoa;
    private String descricao;

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

    @Override
    public String toString() {
        return "StatusPessoaDTO{" +
                "idStatusPessoa=" + idStatusPessoa +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
