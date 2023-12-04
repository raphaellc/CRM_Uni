package src.modelo;

import java.text.SimpleDateFormat;
        import java.util.Date;

public class AnaliseAtendimentoModelo {

    private String observacoes;
    private double valor_resultante;
    private String status;
    private Date dt_primeiro_contato;
    private String responsavel;
    private int duracao_atendimento; // em minutos

    // Construtor
    public AnaliseAtendimentoModelo(String observacoes, double valor_resultante, String status,
                                Date dt_primeiro_contato, String responsavel, int duracao_atendimento) {
        this.observacoes = observacoes;
        this.valor_resultante = valor_resultante;
        this.status = status;
        this.dt_primeiro_contato = dt_primeiro_contato;
        this.responsavel = responsavel;
        this.duracao_atendimento = duracao_atendimento;
    }

    // Métodos getters e setters

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public double getValor_resultante() {
        return valor_resultante;
    }

    public void setValor_resultante(double valor_resultante) {
        this.valor_resultante = valor_resultante;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDt_primeiro_contato() {
        return dt_primeiro_contato;
    }

    public void setDt_primeiro_contato(Date dt_primeiro_contato) {
        this.dt_primeiro_contato = dt_primeiro_contato;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getDuracao_atendimento() {
        return duracao_atendimento;
    }

    public void setDuracao_atendimento(int duracao_atendimento) {
        this.duracao_atendimento = duracao_atendimento;
    }

    // Método para gerar relatório
    public String gerarRelatorio() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        return String.format("Relatório de Atendimento\n" +
                        "Observações: %s\n" +
                        "Valor do Atendimento: %.2f\n" +
                        "Status: %s\n" +
                        "Data do Primeiro Contato: %s\n" +
                        "Responsável: %s\n" +
                        "Duração do Atendimento: %d minutos",
                observacoes, valor_resultante, status,
                formatoData.format(dt_primeiro_contato), responsavel, duracao_atendimento);
    }

    public static void main(String[] args) {
        Date dataContato = new Date();
        RelatorioAtendimento relatorio = new RelatorioAtendimento("Cliente satisfeito", 150.0, "Concluído",
                dataContato, "Atendente1", 30);

        // Gerar e exibir o relatório
        String relatorioFinal = relatorio.gerarRelatorio();
        System.out.println(relatorioFinal);
    }
}