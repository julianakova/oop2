public class Client {
    private String name;
    private Tariff tariff;
    private Integer account;

    public Client(String name, Tariff tariff, Integer account) {
        this.name = name;
        this.tariff = tariff;
        this.account = account;
    }

    public void changeAccount(Integer purchaseAmount) {
        this.account -= purchaseAmount;
    }

    public String getName() {
        return name;
    }

    public Integer getAccount() {
        return account;
    }

    public String getTariff() {
        switch (tariff) {
            case Basic: return "basic";           
            case Premium: return "premium";        
            default: return "Undefined";
        }
    }

    public void printClient() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%s: Tariff[%s], Account - %d ue", name, getTariff(), account);
    }
}
