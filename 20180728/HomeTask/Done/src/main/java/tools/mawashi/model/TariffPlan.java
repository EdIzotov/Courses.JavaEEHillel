package tools.mawashi.model;

public class TariffPlan {
    private int tariffPlanId;
    private String tariffPlanName;
    private String tariffPlanDescription;

    public TariffPlan(int tariffPlanId, String tariffPlanName, String tariffPlanDescription) {
        this.tariffPlanId = tariffPlanId;
        this.tariffPlanName = tariffPlanName;
        this.tariffPlanDescription = tariffPlanDescription;
    }

    public int getTariffPlanId() {
        return tariffPlanId;
    }

    public void setTariffPlanId(int tariffPlanId) {
        this.tariffPlanId = tariffPlanId;
    }

    public String getTariffPlanName() {
        return tariffPlanName;
    }

    public void setTariffPlanName(String tariffPlanName) {
        this.tariffPlanName = tariffPlanName;
    }

    public String getTariffPlanDescription() {
        return tariffPlanDescription;
    }

    public void setTariffPlanDescription(String tariffPlanDescription) {
        this.tariffPlanDescription = tariffPlanDescription;
    }

    @Override
    public String toString() {
        return "TariffPlan{" +
                "tariffPlanId=" + tariffPlanId +
                ", tariffPlanName='" + tariffPlanName + '\'' +
                ", tariffPlanDescription='" + tariffPlanDescription + '\'' +
                '}';
    }
}
