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
    private CampanhaDAO campanha_DAO;
    public Campanha(int idCampanha, String nome, Date dtInicio, String dtFim) {
        this.idCampanha = idCampanha;
        this.nome = nome;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.campanha_DAO = new CampanhaDAO()
    }
    public class Mensagem {
        private final int idMensagem;
        private final String conteudo;
        private final Date dataEnvio;
        private final int idCampanha;
        private final MensagemDAO mensagemDAO;

        public Mensagem(int idMensagem, String conteudo, Date dataEnvio, int idCampanha, Connection connection) {
            this.idMensagem = idMensagem;
            this.conteudo = conteudo;
            this.dataEnvio = dataEnvio;
            this.idCampanha = idCampanha;
            this.mensagemDAO = new MensagemDAO(connection);
        }

        public int getIdMensagem() {
            return idMensagem;
        }

        public String getConteudo() {
            return conteudo;
        }

        public Date getDataEnvio() {
            return dataEnvio;
        }

        public int getIdCampanha() {
            return idCampanha;
        }

        public void enviarMensagem(int idCliente) {
            mensagemDAO.enviarMensagem(idMensagem, idCliente);
        }
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
    public List<CampanhaDTO> buscarTodasCampanhas(){return campanha_DAO.buscarTodasCampanhas()}
    public void associarPublicoAlvo(List<StatusPessoaDTO> statusPessoaDTOList) {
        for (StatusPessoaDTO statusPessoaDTO : statusPessoaDTOList) {
            campanha_DAO.associarPublicoAlvo(idCampanha, statusPessoaDTO.getId());
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
