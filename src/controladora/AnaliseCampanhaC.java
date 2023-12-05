package src.controladora;

import src.modelo.AnaliseCampanhaModelo;
import src.dto.AnaliseCampanhaDto;

import java.util.List;

public class AnaliseCampanhaC {
    private AnaliseCampanhaModelo model;

    public AnaliseCampanhaC() {
        this.model = new AnaliseCampanhaModelo();
    }

    public void selecionarCampanha(String nome) {
        // Faz a chamada para o método de modelo
        List<AnaliseCampanhaDto> campanhas = model.selecionarCampanha(nome);

        // Exibe as campanhas
        System.out.println("\nDados obtidos: ");
        for (AnaliseCampanhaDto campanha : campanhas) {
            System.out.println("\nID: " + campanha.getId_campanha());
            System.out.println("Nome: " + campanha.getNome_campanha());
            System.out.println("Data Início: " + campanha.getDt_inicio_campanha());
            System.out.println("Data Fim: " + campanha.getDt_fim_campanha());
        }
    }
}
