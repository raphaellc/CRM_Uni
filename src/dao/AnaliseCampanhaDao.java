package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.dto.AnaliseCampanhaDto;


public class AnaliseCampanhaDao {

    // Método para selecionar campanhas por nome
    public List<AnaliseCampanhaDto> selecionarCampanha(String nome) {

        List<AnaliseCampanhaDto> campanha = new ArrayList<>();
        Connection conexao = Conexao.conectar();

        if (conexao != null) {
            String sql = "SELECT * FROM campanha WHERE nome = ?";

            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                // Define o parâmetro
                stmt.setString(1, nome);

                // Executa a consulta
                ResultSet resultado = stmt.executeQuery();

                while (resultado.next()) {
                    // Cria um objeto AnaliseCampanhaDto para cada registro retornado
                    AnaliseCampanhaDto campanhaDto = new AnaliseCampanhaDto();
                    campanhaDto.setId_campanha(resultado.getInt("id_campanha"));
                    campanhaDto.setNome_campanha(resultado.getString("nome"));
                    campanhaDto.setDt_inicio_campanha(resultado.getDate("dt_inicio"));
                    campanhaDto.setDt_fim_campanha(resultado.getString("dt_fim"));

                    // Adiciona o AnaliseCampanhaDto à lista
                    campanha.add(campanhaDto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Fecha a conexão após o uso
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return campanha;
    }
}
