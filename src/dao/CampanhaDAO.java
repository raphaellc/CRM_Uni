package dao;

import dto.CampanhaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampanhaDAO {
    private final Connection connection;

    public CampanhaDAO(Connection connection) {
        this.connection = connection;
    }



    public void inserirCampanha(CampanhaDTO campanha) {
        String query = "INSERT INTO campanha (nome, dt_inicio, dt_fim) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, campanha.getNome());
            statement.setDate(2, new java.sql.Date(campanha.getDtInicio().getTime()));
            statement.setString(3, campanha.getDtFim());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizarStatusCampanha(int campanhaId, String novoStatus) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE campanha SET status = ? WHERE id_campanha = ?");
            preparedStatement.setString(1, novoStatus);
            preparedStatement.setInt(2, campanhaId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarProgressoCampanha(int campanhaId, int novoProgresso) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE campanha SET progresso = ? WHERE id_campanha = ?");
            preparedStatement.setInt(1, novoProgresso);
            preparedStatement.setInt(2, campanhaId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void associarPublicoAlvo(int campanhaId, int statusPessoaId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO campanha_publico_alvo (id_campanha, id_status_pessoa) VALUES (?, ?)");
            preparedStatement.setInt(1, campanhaId);
            preparedStatement.setInt(2, statusPessoaId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StatusPessoaDTO> buscarPublicoAlvo(int campanhaId) {
        List<StatusPessoaDTO> publicoAlvo = new ArrayList<>();
        String query = "SELECT status_pessoa.* FROM status_pessoa " +
                "JOIN campanha_publico_alvo ON status_pessoa.id_status_pessoa = campanha_publico_alvo.id_status_pessoa " +
                "WHERE campanha_publico_alvo.id_campanha = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, campanhaId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    StatusPessoaDTO statusPessoa = new StatusPessoaDTO();
                    statusPessoa.setIdStatusPessoa(resultSet.getInt("id_status_pessoa"));
                    statusPessoa.setDescricao(resultSet.getString("descricao"));
                    publicoAlvo.add(statusPessoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publicoAlvo;
    }
}
    public List<CampanhaDTO> buscarTodasCampanhas() {
        List<CampanhaDTO> campanhas = new ArrayList<>();
        String query = "SELECT * FROM campanha";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                CampanhaDTO campanha = new CampanhaDTO();
                campanha.setIdCampanha(resultSet.getInt("id_campanha"));
                campanha.setNome(resultSet.getString("nome"));
                campanha.setDtInicio(resultSet.getDate("dt_inicio"));
                campanha.setDtFim(resultSet.getString("dt_fim"));
                campanhas.add(campanha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return campanhas;
    }

    // Outros métodos, como atualizar e excluir campanhas, podem ser implementados aqui conforme necessário.
}
