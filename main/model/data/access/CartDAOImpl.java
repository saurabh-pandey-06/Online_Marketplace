package access;

import transfer.CartDTO;
import transfer.CustomerDTO;

/**
 * CartDAOImpl helps in implementing functionality
 * associated with the carts of the users.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CartDAOImpl {

    /**
     * Attaching a cart with a particular customer
     * and setting a unique CartID.
     *
     * @param username
     * @return CartDTO
     */
    public CustomerDTO attachCart(String username){
        CustomerDTO customer = CustomerDAOImpl.getInstanceOf().getCustomer(username);
        CartDTO cart = customer.getCart();

        if(cart == null){
            cart = new CartDTO();
            cart.setCartID(username);
            customer.setCart(cart);
            System.out.println("Cart attached with: "+customer.getCart().getCartID());
       }
        return customer;
    }
}
