import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map <String, Integer> productPrice;
    private Map <String, Integer> productStock;

    public Storehouse() {
         this.productPrice = new HashMap<String, Integer>();
         this.productStock = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        productPrice.put(product, price);
        productStock.put(product, stock);
    }

    public int price(String product) {
        if (productPrice.keySet().contains(product)) {
            return productPrice.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (productStock.keySet().contains(product)) {
            return productStock.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {
        int stock = stock(product);
        if (stock != 0) {
            productStock.put(product, stock - 1);
            return true;
        } else {
            return false;
        }
    }

    public Set<String> products() {
        Set<String> products = new HashSet<String>();
        for (String product : productStock.keySet()) {
            if (stock(product) != 0) {
                products.add(product);
            }
        }
        return products;
    }

}
