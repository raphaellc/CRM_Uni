package src.modelo;

import src.dao.AnaliseCampanhaDao;
import src.dto.AnaliseCampanhaDto;

import java.util.List;

public class AnaliseCampanhaModelo {
    private AnaliseCampanhaDao dao;

    public AnaliseCampanhaModelo() {
        this.dao = new AnaliseCampanhaDao();
    }

    public List<AnaliseCampanhaDto> selecionarCampanha(String nome) {
        // Invoca o método DAO
        return dao.selecionarCampanha(nome);
    }
}
