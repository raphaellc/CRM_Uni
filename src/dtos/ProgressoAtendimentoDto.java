package dtos;

import java.time.LocalDate;
import java.util.Date;

public class ProgressoAtendimentoDto {
    int id_caso_atendimento;
    int id_status_caso_atendimento;
    String desc_atualizacao;
    LocalDate data_atualizacao;

    public int getId_caso_atendimento() {
        return id_caso_atendimento;
    }

    public void setId_caso_atendimento(int id_caso_atendimento) {
        this.id_caso_atendimento = id_caso_atendimento;
    }

    public int getId_status_caso_atendimento() {
        return id_status_caso_atendimento;
    }

    public void setId_status_caso_atendimento(int id_status_caso_atendimento) {
        this.id_status_caso_atendimento = id_status_caso_atendimento;
    }

    public String getDesc_atualizacao() {
        return desc_atualizacao;
    }

    public void setDesc_atualizacao(String desc_atualizacao) {
        this.desc_atualizacao = desc_atualizacao;
    }

    public LocalDate getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(LocalDate data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }
}
