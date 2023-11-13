package dto;

import java.sql.Date;

public class CampanhaDTO {
    private int idCampanha;
    private String nome;
    private Date dtInicio;
    private String dtFim;

    public CampanhaDTO(int idCampanha, String nome, Date dtInicio, String dtFim) {
        this.idCampanha = idCampanha;
        this.nome = nome;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public int getIdCampanha() {
        return idCampanha;
    }

    public void setIdCampanha(int idCampanha) {
        this.idCampanha = idCampanha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getDtFim() {
        return dtFim;
    }

    public void setDtFim(String dtFim) {
        this.dtFim = dtFim;
    }
}