package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.CampanhaDAO;
import dao.StatusPessoaDAO;
import dto.CampanhaDTO;

import java.util.Date;

public class Campanha {
    private final int idCampanha;
    private final String nome;
    private final Date dtInicio;
    private final String dtFim;

    public Campanha(int idCampanha, String nome, Date dtInicio, String dtFim) {
        this.idCampanha = idCampanha;
        this.nome = nome;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public int getIdCampanha() {
        return idCampanha;
    }

    public String getNome() {
        return nome;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public String getDtFim() {
        return dtFim;
    }

    @Override
    public String toString() {
        return "Campanha{" +
                "idCampanha=" + idCampanha +
                ", nome='" + nome + '\'' +
                ", dtInicio=" + dtInicio +
                ", dtFim='" + dtFim + '\'' +
                '}';
    }
}
