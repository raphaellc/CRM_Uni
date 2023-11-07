import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampanhaDAO {
    private Connection connection;

    public CampanhaDAO(Connection connection) {
        this.connection = connection;
    }

    public CampanhaDAO() {
        this.connection = Conexao.conectar(); // Use sua classe de conexão personalizada
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
