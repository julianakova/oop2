public class App {
    public static void main(String[] args) {
        Market market = new Market();
        
        market.takeOrder(new Client("Иван", Tariff.Basic, 3000), 1500);
        market.takeOrder(new Client("Макс", Tariff.Premium, 33000), 5000);
        market.takeOrder(new Client("Маша", Tariff.Premium, 35000), 15000);
        market.takeOrder(new Client("Денис", Tariff.Basic, 8000), 5000);
        market.takeOrder(new Client("Андрей", Tariff.Basic, 1000), 4000);

        market.update();
        
    }
}
