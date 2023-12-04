package dtos;

import java.time.LocalDate;
import java.util.Date;

public class ProgressoAtendimentoDto {
    int id_atendimento;
    int id_status_caso_atendimento;
    String desc_atualizacao;
    LocalDate data_atualizacao;

    public int getIdCasoAtendimento() {
        return id_atendimento;
    }

    public void setIdCasoAtendimento(int id_caso_atendimento) {
        this.id_atendimento = id_caso_atendimento;
    }

    public int getIdStatusCasoAtendimento() {
        return id_status_caso_atendimento;
    }

    public void setIdStatusCasoAtendimento(int id_status_caso_atendimento) {
        this.id_status_caso_atendimento = id_status_caso_atendimento;
    }

    public String getDescAtualizacao() {
        return desc_atualizacao;
    }

    public void setDescAtualizacao(String desc_atualizacao) {
        this.desc_atualizacao = desc_atualizacao;
    }

    public LocalDate getDataAtualizacao() {
        return data_atualizacao;
    }

    public void setDataAtualizacao(LocalDate data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

    public String toString() {
        return "Id do Caso de Atendimento: " + id_atendimento +
                ", Id Do Status do Caso de Atendimento: " + id_status_caso_atendimento +
                ", Descrição da Atualização: " + desc_atualizacao +
                ", Data da atualização:  " + data_atualizacao;
    }
}
