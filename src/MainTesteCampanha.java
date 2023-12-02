package src;

import src.dao.AnaliseCampanhaDao;
import src.dto.AnaliseCampanhaDto;

import java.util.List;

public class MainTesteCampanha {

    public static void main(String[] args) {

        AnaliseCampanhaDao analise_campanha_dao = new AnaliseCampanhaDao();

        List<AnaliseCampanhaDto> campanha = analise_campanha_dao.selecionarCampanha("Campanha3");

        // Exibindo os valores da tabela
        if (campanha.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
        } else {
            for (AnaliseCampanhaDto valor : campanha) {
                System.out.println("ID: " + valor.getId_campanha());
                System.out.println("Nome: " + valor.getNome_campanha());
                System.out.println("Data Início: " + valor.getDt_inicio_campanha());
                System.out.println("Data Fim: " + valor.getDt_fim_campanha());
            }
        }
    }
}
