package dtos;

public class FormatoAtendimentoDto {
    public int id_formato_atendimento;
    public String nome_formato;

    //Construtor
    public FormatoAtendimentoDto() {
    }

    //Getters e setters
    public int getIdFormatoAtendimento() {
        return id_formato_atendimento;
    }

    public void setIdFormatoAtendimento(int id_formato_atendimento) {
        this.id_formato_atendimento = id_formato_atendimento;
    }

    public String getNomeFormato() {
        return nome_formato;
    }

    public void setNomeFormato(String nome_formato) {
        this.nome_formato = nome_formato;
    }
}
