@SuppressWarnings("hiding")
public class Order<Client, Integer> {
    private Integer purchaseAmount;
    private Client client;

    public Order(Client client, Integer purchaseAmount) {
        this.client = client;
        this.purchaseAmount = purchaseAmount;
    }

    public Client getClient() {
        return client;
    }

    public Integer getPurchaseAmount() {
        return this.purchaseAmount;
    }
}
