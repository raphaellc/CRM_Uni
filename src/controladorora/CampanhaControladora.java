import dao.CampanhaDAO;
import dao.StatusPessoaDAO;
import dto.CampanhaDTO;
import dto.StatusPessoaDTO;
import modelo.Campanha;
import modelo.StatusPessoa;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class CampanhaControladora {
    private final CampanhaDAO campanhaDAO;
    private final StatusPessoaDAO statusPessoaDAO;
    private  Campanha camp = new Campanha();

    public CampanhaModelo(Connection connection) {
        this.campanhaDAO = new CampanhaDAO(connection);
        this.statusPessoaDAO = new StatusPessoaDAO(connection);
    }

    public void inserirCampanha(CampanhaDTO campanhaDTO) {
        camp.inserirCampanha(campanhaDTO);
    }

    public List<CampanhaDTO> buscarTodasCampanhas() {
        return camp.buscarTodasCampanhas();
    }

    public void criarNovaCampanha(String nome, Date dtInicio, String dtFim) {
        if (cargoPessoaDAO.hasRequiredRole(idCargoPessoa)) {
            CampanhaDTO novaCampanhaDTO = new CampanhaDTO();
            novaCampanhaDTO.setNome(nome);
            novaCampanhaDTO.setDtInicio(dtInicio);
            novaCampanhaDTO.setDtFim(dtFim);
        }
    }
    public void criarPublicoAlvo(int campanhaId, List<StatusPessoaDTO> statusPessoaDTOList) {
        if (cargoPessoaDAO.hasRequiredRole(idCargoPessoa)) {
            CampanhaDTO campanha = camp.getCampanhaById(campanhaId);
            if (campanha != null) {
                // Lógica para associar o público-alvo à campanha.
                for (StatusPessoaDTO statusPessoaDTO : statusPessoaDTOList) {
                    StatusPessoaDTO existingStatus = statusPessoaDAO.getStatusPessoaById(statusPessoaDTO.getId());
                    if (existingStatus != null) {
                        campanhaDAO.adicionarPublicoAlvo(campanhaId, statusPessoaDTO.getId());
                        // Outras lógicas necessárias...
                    } else {
                        System.out.println("Status de pessoa não encontrado para ID: " + statusPessoaDTO.getId());
                        // Lidar com o caso em que o status de pessoa não existe
                    }
                }
            }
        }
    }

    public void iniciarCampanha(int campanhaId) {
        if (cargoPessoaDAO.hasRequiredRole(idCargoPessoa)) {
            CampanhaDTO campanha = camp.getCampanhaById(campanhaId);
            if (campanha != null) {
                // Lógica para iniciar a execução da campanha em tempo real.
                campanhaDAO.atualizarStatusCampanha(campanhaId, "Em Execução");
                // Outras lógicas necessárias...
            }
        }
    }
    public void encerrarCampanha(int campanhaId) {
        if (cargoPessoaDAO.hasRequiredRole(idCargoPessoa)) {
            CampanhaDTO campanha = camp.getCampanhaById(campanhaId);
            if (campanha != null) {
                // Lógica para encerrar a execução da campanha em tempo real.
                camp.atualizarStatusCampanha(campanhaId, "Encerrada");
                // Outras lógicas necessárias...
            }
        }
    }
    public void atualizarProgressoCampanha(int campanhaId, int progresso) {
        if (cargoPessoaDAO.hasRequiredRole(idCargoPessoa)) {
            CampanhaDTO campanha = camp.getCampanhaById(campanhaId);
            if (campanha != null) {
                // Lógica para atualizar o progresso da campanha em tempo real.
                camp.atualizarProgressoCampanha(campanhaId, progresso);
                // Outras lógicas necessárias...
            }
        }
    }
    public void enviarMensagemCampanha(int campanhaId, String conteudo) {
        if (cargoPessoaDAO.hasRequiredRole(idCargoPessoa)) {
            CampanhaDTO campanha = camp.getCampanhaById(campanhaId);
            if (campanha != null) {
                Mensagem novaMensagem = new Mensagem(0, conteudo, new Date(), campanhaId, connection);
                novaMensagem.enviarMensagemParaClientes();
            }
}
