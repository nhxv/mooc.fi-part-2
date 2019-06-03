import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    private Map<String, Purchase> basket;

    public ShoppingBasket() {
        this.basket = new HashMap<String, Purchase>();
    }


    public void add(String product, int price) {
        Purchase thing = new Purchase(product, 1, price);
        if (!basket.keySet().contains(product)) {
            basket.put(product, thing);
        } else {
            basket.get(product).increaseAmount();
        }
    }

    public int price() {
        int totalPrice = 0;
        for (String product : basket.keySet()) {
            totalPrice += basket.get(product).price();
        }
        return totalPrice;
    }

    public void print() {
        for (String product : basket.keySet()) {
            System.out.println(basket.get(product));
        }
    }
}
