package src.modelo;
import java.text.SimpleDateFormat;
import java.util.Date;
public class AnaliseCampanhaModelo {
    private int id_campanha;
    private String nome_campanha;
    private Date dt_inicio_campanha;
    private Date dtFimCampanha;

    // Construtor
    public RelatorioCampanha(int id_campanha, String nome_campanha, Date dt_inicio_campanha, Date dt_fim_campanha) {
        this.id_campanha = id_campanha;
        this.nome_campanha = nome_campanha;
        this.dt_inicio_campanha = dt_inicio_campanha;
        this.dt_fim_campanha = dt_fim_campanha;
    }

    // Métodos getters e setters

    public int getIdCampanhaid_campanha() {
        return id_campanha;
    }

    public void setId_Campanha(int id_campanha) {
        this.id_campanha = id_campanha;
    }

    public String getNome_campanha() {
        return nome_campanha;
    }

    public void setNome_campanha(String nome_campanha) {
        this.nome_campanha = nome_campanha;
    }

    public Date getDt_inicio_campanhadt_inicio_campanha() {
        return dt_inicio_campanha;
    }

    public void setDt_inicio_campanha(Date dt_inicio_campanha) {
        this.dt_inicio_campanha = dt_inicio_campanha;
    }

    public Date getDt_fim_campanha() {
        return dt_fim_campanha;
    }

    public void setDt_fim_campanha(Date dt_fim_campanha) {
        this.dt_fim_campanha = dt_fim_campanha;
    }

    // Método para gerar relatório
    public String gerarRelatorio() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        return String.format("Relatório da Campanha %s (ID: %d)\n" +
                        "Período: %s a %s\n" +
                        "Total de Cliques: %d\n" +
                        "Total de Conversões: %d",
                nome_campanha, id_campanha, formatoData.format(dt_inicio_campanhaCampanha),
                formatoData.format(dt_fim_campanha);
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe
        RelatorioCampanha relatorio = new RelatorioCampanha(1, "Campanha de Verão", new Date(), new Date());

        // Gerar e exibir o relatório
        String relatorioFinal = relatorio.gerarRelatorio();
        System.out.println(relatorioFinal);
    }
}