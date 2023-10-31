public interface MarketingCampaignDao {
    List<MarketingCampaign> getAllCampaigns();
    MarketingCampaign getCampaignById(int campaignId);
    void addCampaign(MarketingCampaign campaign);
    void updateCampaign(MarketingCampaign campaign);
    void deleteCampaign(int campaignId);
}

public class MarketingCampaignDaoImpl implements MarketingCampaignDao {
    private List<MarketingCampaign> campaigns;

    public MarketingCampaignDaoImpl() {
        this.campaigns = new ArrayList<>();
    }


    @Override
    public List<MarketingCampaign> getAllCampaigns() {
        return campaigns;
    }

    @Override
    public MarketingCampaign getCampaignById(int campaignId) {
        for (MarketingCampaign campaign : campaigns) {
            if (campaign.getCampaignId() == campaignId) {
                return campaign;
            }
        }
        return null;
    }

    @Override
    public void addCampaign(MarketingCampaign campaign) {
        campaigns.add(campaign);
    }

    @Override
    public void updateCampaign(MarketingCampaign campaign) {
        for (MarketingCampaign c : campaigns) {
            if (c.getCampaignId() == campaign.getCampaignId()) {
                c.setCampaignName(campaign.getCampaignName());
                c.setDescription(campaign.getDescription());
                c.setStartDate(campaign.getStartDate());
                c.setEndDate(campaign.getEndDate());
                // Atualize outros campos conforme necessário
            }
        }
    }

    @Override
    public void deleteCampaign(int campaignId) {
        campaigns.removeIf(campaign -> campaign.getCampaignId() == campaignId);
    }
}

//--------------------------------//

import java.util.List;

public interface StatusPessoaDao {
    List<StatusPessoa> getAllStatusPessoa();
    StatusPessoa getStatusPessoaById(int statusPessoaId);
    void addStatusPessoa(StatusPessoa statusPessoa);
    void updateStatusPessoa(StatusPessoa statusPessoa);
    void deleteStatusPessoa(int statusPessoaId);
}

public class StatusPessoaDaoImpl implements StatusPessoaDao {
    private List<StatusPessoa> statusPessoas;

    public StatusPessoaDaoImpl() {
        this.statusPessoas = new ArrayList<>();
    }

    @Override
    public List<StatusPessoa> getAllStatusPessoa() {
        return statusPessoas;
    }

    @Override
    public StatusPessoa getStatusPessoaById(int statusPessoaId) {
        for (StatusPessoa statusPessoa : statusPessoas) {
            if (statusPessoa.getStatusPessoaId() == statusPessoaId) {
                return statusPessoa;
            }
        }
        return null;
    }

    @Override
    public void addStatusPessoa(StatusPessoa statusPessoa) {
        statusPessoas.add(statusPessoa);
    }

    @Override
    public void updateStatusPessoa(StatusPessoa statusPessoa) {
        for (StatusPessoa sp : statusPessoas) {
            if (sp.getStatusPessoaId() == statusPessoa.getStatusPessoaId()) {
                sp.setNome(statusPessoa.getNome());
                sp.setStatus(statusPessoa.getStatus());
                // Atualize outros campos conforme necessário
            }
        }
    }

    @Override
    public void deleteStatusPessoa(int statusPessoaId) {
        statusPessoas.removeIf(statusPessoa -> statusPessoa.getStatusPessoaId() == statusPessoaId);
    }
}