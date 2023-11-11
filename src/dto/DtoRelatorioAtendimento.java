package src.dto;
import java.util.Date;

public class DtoRelatorioAtendimento {
    private String obersacoes;
    private float valor_resultante;
    private String formato_atendimento;
    private String status;
    private Date dt_primeiro_contato;
    private String responsavel;
    private int duracao_atendimento;

    public String getObersacoes() {
        return obersacoes;
    }

    public void setObersacoes(String obersacoes) {
        this.obersacoes = obersacoes;
    }

    public float getValor_resultante() {
        return valor_resultante;
    }

    public void setValor_resultante(float valor_resultante) {
        this.valor_resultante = valor_resultante;
    }

    public String getFormato_atendimento() {
        return formato_atendimento;
    }

    public void setFormato_atendimento(String formato_atendimento) {
        this.formato_atendimento = formato_atendimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDt_primeiro_contato() {
        return dt_primeiro_contato;
    }

    public void setDt_primeiro_contato(Date dt_primeiro_contato) {
        this.dt_primeiro_contato = dt_primeiro_contato;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getDuracao_atendimento() {
        return duracao_atendimento;
    }

    public void setDuracao_atendimento(int duracao_atendimento) {
        this.duracao_atendimento = duracao_atendimento;
    }
}
