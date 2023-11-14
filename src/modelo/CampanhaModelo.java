import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
package modelos;

import daos.CampanhaDAO;
import daos.Conexao;
import dtos.CampanhaDTO;

import java.util.ArrayList;

public class CampanhaModelo {
    private List<CampanhaDTO> campanhas;
    private CampanhaDAO campanhaDAO;
    private Conexao conexao;

    public CampanhaModelo() {
        conexao = new Conexao();
        campanhaDAO = new CampanhaDAO(conexao);
        campanhas = new ArrayList<>();
    }

    public void inserirCampanha(CampanhaDTO campanha) {
        campanhaDAO.inserirCampanha(campanha);
    }

    public List<CampanhaDTO> buscarTodasCampanhas() {
        return campanhaDAO.buscarTodasCampanhas();
    }

    // Outros métodos relacionados a campanhas podem ser adicionados conforme necessário.
}
