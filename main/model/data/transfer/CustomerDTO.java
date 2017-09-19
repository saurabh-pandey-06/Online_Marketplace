package transfer;

/**
 * CustomerDTO helps in communicating and manipulating
 * customer specific data within the underlying
 * storage mechanism. CustomerDTO is a simple POJO class
 * that extends UserDTO.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CustomerDTO extends UserDTO {

    // Reference of CartDTO
    private CartDTO cart;

    public CustomerDTO(){}

    public CustomerDTO(String id,String name, String username, String password, String role){

        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // getter and setter methods
    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }
}
