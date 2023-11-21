package modelo;

public class StatusPessoa {
    private final int idStatusPessoa;
    private final String descricao;

    public StatusPessoa(int idStatusPessoa, String descricao) {
        this.idStatusPessoa = idStatusPessoa;
        this.descricao = descricao;
    }

    public int getIdStatusPessoa() {
        return idStatusPessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "StatusPessoa{" +
                "idStatusPessoa=" + idStatusPessoa +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
