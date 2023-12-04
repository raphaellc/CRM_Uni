package dtos;

public class StatusAtendimentoDto {
    public int id_status_atendimento;
    public String desc;

    //Construtor
    public StatusAtendimentoDto() {
    }

    //Getter e setters

    public int getIdStatusAtendimento() {
        return id_status_atendimento;
    }

    public void setIdStatusAtendimento(int id_status_atendimento) {
        this.id_status_atendimento = id_status_atendimento;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescStatusAtendimento() {
        return desc;
    }



    public void getDescStatusAtendimento(String desc) {
        this.desc = desc;
    }

    public String toString() {
        return "idStatusAtendimento: " + id_status_atendimento +
                "Descrição do Status de Atendimento: " + desc;
    }

}

