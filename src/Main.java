import dao.CampanhaDAO;
import dao.StatusPessoaDAO;
import dto.CampanhaDTO;
import dto.StatusPessoaDTO;
import Controladora;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Configuração da conexão com o banco de dados
        String jdbcUrl = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, senha)) {
            // Teste do CampanhaDAO
            CampanhaDAO campanhaDAO = new CampanhaDAO(connection);

            // Inserir uma campanha
            CampanhaDTO novaCampanha = new CampanhaDTO();
            novaCampanha.setNome("Campanha de Teste");
            novaCampanha.setDtInicio(new Date());
            novaCampanha.setDtFim("2023-12-31");
            campanhaDAO.inserirCampanha(novaCampanha);

            // Buscar todas as campanhas
            List<CampanhaDTO> campanhas = campanhaDAO.buscarTodasCampanhas();
            System.out.println("Campanhas:");
            for (CampanhaDTO campanha : campanhas) {
                System.out.println(campanha);
            }

            // Teste do StatusPessoaDAO
            StatusPessoaDAO statusPessoaDAO = new StatusPessoaDAO(connection);

            // Buscar todos os status de pessoa
            List<StatusPessoaDTO> statusPessoas = statusPessoaDAO.getAllStatusPessoa();
            System.out.println("Status de Pessoa:");
            for (StatusPessoaDTO statusPessoa : statusPessoas) {
                System.out.println(statusPessoa);
            }

            // Adicionar um novo status de pessoa
            StatusPessoaDTO novoStatusPessoa = new StatusPessoaDTO();
            novoStatusPessoa.setDescricao("Novo Status");
            statusPessoaDAO.addStatusPessoa(novoStatusPessoa);

            // Atualizar um status de pessoa
            StatusPessoaDTO statusPessoaAtualizado = statusPessoas.get(0);
            statusPessoaAtualizado.setDescricao("Status Atualizado");
            statusPessoaDAO.updateStatusPessoa(statusPessoaAtualizado);

            // Deletar um status de pessoa (certifique-se de que o id existe)
            int idStatusPessoaParaDeletar = statusPessoas.get(1).getIdStatusPessoa();
            statusPessoaDAO.deleteStatusPessoa(idStatusPessoaParaDeletar);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // Criando uma instância do controlador de marketing
        GerenteMarketingController gerenteMarketingController = new GerenteMarketingController();

        // Criando dados para uma nova campanha
        String objetivo = "Promoção de Aniversário";
        Date dataInicio = new Date();
        Date dataFim = new Date(dataInicio.getTime() + (7 * 24 * 60 * 60 * 1000)); // Adicionando uma semana à data de início
        List<ClienteDTO> publicoAlvo = // Defina o público-alvo conforme necessário;
                String conteudo = "Descontos especiais para clientes fiéis!";

        // Criando uma nova campanha usando o controlador
        gerenteMarketingController.campanhaModelo.criarNovaCampanha(objetivo, dataInicio, dataFim, publicoAlvo, conteudo);

        // Exemplo de como buscar todas as campanhas e exibi-las
        List<CampanhaDTO> todasCampanhas = gerenteMarketingController.campanhaModelo.buscarTodasCampanhas();
        System.out.println("Todas as Campanhas:");
        for (CampanhaDTO campanha : todasCampanhas) {
            System.out.println(campanha);
        }

        // Exemplo de como analisar os resultados de uma campanha específica (supondo que exista pelo menos uma campanha)
        if (!todasCampanhas.isEmpty()) {
            gerenteMarketingController.campanhaModelo.analisarResultadosCampanha(todasCampanhas.get(0).getId()); // Substitua getId() pelo método real
        }
    }
}

}






