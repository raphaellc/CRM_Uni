package dao;

public class CampanhaMarketing {
    private String campaignName;
    private String description;
    private String startDate;
    private String endDate;

    public CampanhaMarketing(String campaignName, String description, String startDate, String endDate) {
        this.campaignName = campaignName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}


