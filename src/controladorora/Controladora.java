import dao.CampanhaDAO;
import dao.StatusPessoaDAO;
import dto.CampanhaDTO;
import dto.StatusPessoaDTO;
import modelo.Campanha;
import modelo.StatusPessoa;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class CampanhaModelo {
    private final CampanhaDAO campanhaDAO;
    private final StatusPessoaDAO statusPessoaDAO;

    public CampanhaModelo(Connection connection) {
        this.campanhaDAO = new CampanhaDAO(connection);
        this.statusPessoaDAO = new StatusPessoaDAO(connection);
    }

    public void inserirCampanha(CampanhaDTO campanhaDTO) {
        campanhaDAO.inserirCampanha(campanhaDTO);
    }

    public List<CampanhaDTO> buscarTodasCampanhas() {
        return campanhaDAO.buscarTodasCampanhas();
    }

    public void criarNovaCampanha(String nome, Date dtInicio, String dtFim) {
        // 2. O gerente cria uma nova campanha de marketing, definindo objetivos e datas de execução.
        CampanhaDTO novaCampanhaDTO = new CampanhaDTO();
        novaCampanhaDTO.setNome(nome);
        novaCampanhaDTO.setDtInicio(dtInicio);
        novaCampanhaDTO.setDtFim(dtFim);

        // 3. O gerente cria uma nova campanha no modelo usando o DTO.
        inserirCampanha(novaCampanhaDTO);
        import dao.CampanhaDAO;
import dao.StatusPessoaDAO;
import dto.CampanhaDTO;
import dto.StatusPessoaDTO;
import modelo.Campanha;
import modelo.StatusPessoa;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

        public class CampanhaModelo {
            private final CampanhaDAO campanhaDAO;
            private final StatusPessoaDAO statusPessoaDAO;

            public CampanhaModelo(Connection connection) {
                this.campanhaDAO = new CampanhaDAO(connection);
                this.statusPessoaDAO = new StatusPessoaDAO(connection);
            }

            public void inserirCampanha(CampanhaDTO campanhaDTO) {
                campanhaDAO.inserirCampanha(campanhaDTO);
            }

            public List<CampanhaDTO> buscarTodasCampanhas() {
                return campanhaDAO.buscarTodasCampanhas();
            }

            public void criarNovaCampanha(String nome, Date dtInicio, String dtFim) {
                CampanhaDTO novaCampanhaDTO = new CampanhaDTO();
                novaCampanhaDTO.setNome(nome);
                novaCampanhaDTO.setDtInicio(dtInicio);
                novaCampanhaDTO.setDtFim(dtFim);


                inserirCampanha(novaCampanhaDTO);
                if (!todasCampanhas.isEmpty()) {
                    int idCampanhaParaRastrear = todasCampanhas.get(0).getIdCampanha(); // Substitua pelo ID real da campanha
                    gerenteMarketingController.campanhaModelo.iniciarCampanha(idCampanhaParaRastrear);

                }

                public List<StatusPessoaDTO> getAllStatusPessoa() {
                    return statusPessoaDAO.getAllStatusPessoa();
                }

                public StatusPessoaDTO getStatusPessoaById(int idStatusPessoa) {
                    return statusPessoaDAO.getStatusPessoaById(idStatusPessoa);
                }

                // Outros métodos relacionados às ações do gerente de marketing podem ser adicionados conforme necessário.
            }

        }

    public List<StatusPessoaDTO> getAllStatusPessoa() {
        return statusPessoaDAO.getAllStatusPessoa();
    }

    public StatusPessoaDTO getStatusPessoaById(int idStatusPessoa) {
        return statusPessoaDAO.getStatusPessoaById(idStatusPessoa);
    }

    // Outros métodos relacionados às ações do gerente de marketing podem ser adicionados conforme necessário.
}
