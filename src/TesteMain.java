package src;

import src.dao.AnaliseCampanhaDao;
import src.dto.AnaliseCampanhaDto;

import java.util.List;

public class TesteMain {

    public static void main(String[] args) {

        AnaliseCampanhaDao analise_campanha_dao = new AnaliseCampanhaDao();

        List<AnaliseCampanhaDto> campanha = analise_campanha_dao.selecionarCampanha("Campanha3");

        System.out.println(campanha);
    }
}
