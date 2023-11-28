package src.dto;

import java.util.Date;

public class AnaliseCampanhaDto {
    private int id_campanha;
    private String nome_campanha;
    private Date dt_inicio_campanha;
    private String dt_fim_campanha;

    // Construtor padrao
    public AnaliseCampanhaDto() {
    }

    // Construtor personalizado
    public AnaliseCampanhaDto(int id_campanha, String nome_campanha, Date dt_inicio_campanha, String dt_fim_campanha) {
        this.id_campanha = id_campanha;
        this.nome_campanha = nome_campanha;
        this.dt_inicio_campanha = dt_inicio_campanha;
        this.dt_fim_campanha = dt_fim_campanha;
    }

    // Getter and Setter
    public int getId_campanha() {
        return id_campanha;
    }

    public void setId_campanha(int id_campanha) {
        this.id_campanha = id_campanha;
    }

    public String getNome_campanha() {
        return nome_campanha;
    }

    public void setNome_campanha(String nome_campanha) {
        this.nome_campanha = nome_campanha;
    }

    public Date getDt_inicio_campanha() {
        return dt_inicio_campanha;
    }

    public void setDt_inicio_campanha(Date dt_inicio_campanha) {
        this.dt_inicio_campanha = dt_inicio_campanha;
    }

    public String getDt_fim_campanha() {
        return dt_fim_campanha;
    }

    public void setDt_fim_campanha(String dt_fim_campanha) {
        this.dt_fim_campanha = dt_fim_campanha;
    }
}

