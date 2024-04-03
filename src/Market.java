import java.util.LinkedList;
import java.util.Queue;

public class Market implements MarketBehaviour, QueueBehaviour{
    private Queue<Order<Client, Integer>> queueBasic = new LinkedList<>();
    private Queue<Order<Client, Integer>> queuePremium = new LinkedList<>();
    @Override
    public void takeOrder(Client client, Integer purchaseAmount) {
        if (client.getAccount() < purchaseAmount) {
            System.out.println("На вашем счете недостаточно средств!");
        } else {
            Order<Client, Integer> order = new Order<Client,Integer>(client, purchaseAmount);

            if (client.getTariff().equals("basic")) this.queueBasic.offer(order);
            if (client.getTariff().equals("premium")) this.queuePremium.offer(order);
            update(client, purchaseAmount);
        }    
    }

    public void getOrder() {
        if(!queuePremium.isEmpty()) {
            System.out.format("Заказ на имя %s на сумму %d выдан, остаток счета %d\n", 
            queuePremium.peek().getClient().getName(), queuePremium.peek().getPurchaseAmount(), queuePremium.poll().getClient().getAccount());
            update();
        } else {
            System.out.format("Заказ на имя %s на сумму %d выдан, остаток счета %d\n", 
            queueBasic.peek().getClient().getName(), queueBasic.peek().getPurchaseAmount(), queueBasic.poll().getClient().getAccount());
            update();
        }
    }

    @Override
    public void update() {
        if (queuePremium.isEmpty() && queueBasic.isEmpty()) {
            System.out.println("Все заказы исполнены, очередь пуста!");
        } else {
            getOrder();
        }
    }

    public void update(Client client, Integer purchaseAmount) {
        client.changeAccount(purchaseAmount);
        System.out.format("На имя %s, заказ на сумму: %d ue успешно создан\n", client.getName(), purchaseAmount);
    }
}
