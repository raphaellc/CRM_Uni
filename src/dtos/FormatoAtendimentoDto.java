package dtos;

public class FormatoAtendimentoDto {
    public int id_formato_atendimento;
    public String nome_formato;

    //Construtor
    public FormatoAtendimentoDto() {
    }

    //Getters e setters
    public int getId_formato_atendimento() {
        return id_formato_atendimento;
    }

    public void setId_formato_atendimento(int id_formato_atendimento) {
        this.id_formato_atendimento = id_formato_atendimento;
    }

    public String getNome_formato() {
        return nome_formato;
    }

    public void setNome_formato(String nome_formato) {
        this.nome_formato = nome_formato;
    }
}
