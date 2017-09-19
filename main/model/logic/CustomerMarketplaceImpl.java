package logic;

import access.*;
import authorize.Session;
import transfer.CartDTO;
import transfer.CustomerDTO;
import transfer.ProductDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Map;

/**
 * CustomerMarketplaceImpl provides implementation logic for
 * CustomerMarketplace interface. It holds the business logic
 * for functionalities that are specific to the customers.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CustomerMarketplaceImpl extends UnicastRemoteObject implements CustomerMarketplace {

    private CustomerDAO customerDAO;

    /*
     * Constructor for CustomerMarketplaceImpl class.
     * Instantiating the Customer DAO.
     * Calls the constructor of UnicastRemoteObject.
     *
     * @throws RemoteException
     */
    public CustomerMarketplaceImpl() throws RemoteException {
        super();
        customerDAO = CustomerDAOImpl.getInstanceOf();
    }

    /**
     * Provides the logic for registering the customer
     *
     * @param customerDTO
     * @return String
     * @throws RemoteException
     */
    @Override
    public String registrationService(Session session, CustomerDTO customerDTO) throws RemoteException {
        String response = null;

        synchronized (this){
            try {
                if (customerDAO.getCustomer(customerDTO.getUsername()) == null) {
                    customerDAO.addCustomer(customerDTO);
                    response = "Registration Successful!";
                } else
                    response = "Username Already Taken!";

            } catch (Exception e) {
                response = "Internal Server Error. Cannot Register You Now!";

            } finally {
                return response;
            }
        }
    }

    /**
     * Provides the logic for adding items to the customer's cart
     *
     * @param productID
     * @return boolean
     * @throws RemoteException
     */
    @Override
    public Object[] addItemToCart(Session session, String productID, int quantity) throws RemoteException {

        String response = "Cannot Add Requested Item!";
        Object o[] = new Object[2];

        synchronized (this){
            ProductDAO productDAO = ProductDAOImpl.getInstanceOf();
            ProductDTO product = productDAO.getProduct(productID);
            if (product != null && product.getQuantity() >= quantity) {
                System.out.println(session.userDTO.getUsername());
                CustomerDTO customerDTO = (CustomerDTO) session.userDTO;
                CartDTO cart = customerDTO.getCart();

                if (cart != null) {
                    System.out.println("Current Items: " + cart.getCurrentItems());
                    cart.setCurrentItems(productID, quantity);
                    customerDTO.setCart(cart);
                    session.userDTO = customerDTO;

                    // System.out.println("Before in stock: "+productID+" : "+product.getQuantity());
                    //product.setQuantity(product.getQuantity() - quantity);
                    String value = String.valueOf(product.getQuantity() - quantity);
                    productDAO.updateProduct(productID, "Quantity", value);
                    // System.out.println("After in stock: "+productID+" : "+product.getQuantity());
                    response = "Item Added Successfully!";
                    System.out.println("Cart Items: " + cart.getCurrentItems());
                } else
                    System.out.println("Cart not found!");

            }
            o[0] = response;
            o[1] = session;
            return o;
        }
    }

    /**
     * Provides the logic for removing items from the customer's cart
     *
     * @param productID
     * @return boolean
     * @throws RemoteException
     */
    @Override
    public Object[] removeItemFromCart(Session session, String productID, int quantity) throws RemoteException {

        String response = "Cannot Remove Requested Item!";
        Object o[] = new Object[2];

        synchronized (this){
            CustomerDTO customerDTO = (CustomerDTO) session.userDTO;
            CartDTO cart = customerDTO.getCart();
            ProductDAO productDAO = ProductDAOImpl.getInstanceOf();
            ProductDTO product = productDAO.getProduct(productID);
            if (cart.getCurrentItems() != null) {
                Iterator i = cart.getCurrentItems().entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry val = (Map.Entry) i.next();
                    String pid = (String) val.getKey();
                    int quantity_in = (Integer) val.getValue();

                    if (pid.equals(productID) && quantity_in >= quantity) {

                        // System.out.println("Before in stock: "+productID+" : "+product.getQuantity());
                        //product.setQuantity(product.getQuantity() + quantity);
                        String value = String.valueOf(product.getQuantity() + quantity);
                        productDAO.updateProduct(productID, "Quantity", value);
                        // System.out.println("After in stock: "+productID+" : "+product.getQuantity());

                        cart.setCurrentItems(productID, -quantity);
                        customerDTO.setCart(cart);
                        session.userDTO = customerDTO;
                        response = "Item Removed Successfully!";
                        System.out.println("Cart Items: " + cart.getCurrentItems());
                    }
                }
            }
            o[0] = response;
            o[1] = session;
            return o;
        }
    }

    /**
     * Provides the logic for purchasing items
     *
     * @param session
     * @throws RemoteException
     */
    @Override
    public Object[] purchaseItems(Session session) throws RemoteException {

        double sum = 0;
        Object o[] = new Object[2];
        synchronized (this){
            CustomerDTO customerDTO = (CustomerDTO) session.userDTO;
            CartDTO cart = customerDTO.getCart();
            if (cart.getCurrentItems() != null) {
                Iterator i = cart.getCurrentItems().entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry val = (Map.Entry) i.next();
                    String pid = (String) val.getKey();
                    int quantity = (Integer) val.getValue();
                    double price = ProductDAOImpl.getInstanceOf().getProduct(pid).getPrice();
                    double total = price * quantity;
                    sum += total;
                }
            }

            System.out.println("Total: " + sum);
            cart.empty();
            customerDTO.setCart(cart);
            session.userDTO = customerDTO;
            o[0] = sum;
            o[1] = session;
            return o;
        }
    }
}
