package transfer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * CartDTO helps in communicating and manipulating
 * cart specific data within the underlying
 * storage mechanism. CartDTO is a simple POJO class
 * having getter and setter methods.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CartDTO implements Serializable{

    private String cartID;
    private Map<String, Integer> currentItems = new HashMap<>();

    // getter and setter methods.
    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public Map<String, Integer> getCurrentItems() {
        return currentItems;
    }

    public void setCurrentItems(String productID, int quantity) {
        if(this.currentItems.containsKey(productID))
            quantity = this.currentItems.get(productID) + quantity;
        this.currentItems.put(productID,quantity);
    }

    public void empty(){
        this.currentItems.clear();
    }
}

