package tools.mawashi.model;

public class Account {
    private int accountId;
    private String accountName;
    private TariffPlan accountTariffPlan;

    public Account(int accountId, String accountName, TariffPlan accountTariffPlan) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountTariffPlan = accountTariffPlan;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public TariffPlan getAccountTariffPlan() {
        return accountTariffPlan;
    }

    public void setAccountTariffPlan(TariffPlan accountTariffPlan) {
        this.accountTariffPlan = accountTariffPlan;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountTariffPlan=" + accountTariffPlan +
                '}';
    }
}
