package user;

import authorize.Session;
import logic.CustomerMarketplace;
import transfer.CustomerDTO;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * CustomerController is specifically concerned with the
 * functionalities associated with the customer.
 *
 * @author Saurabh
 * @version 2.0
 */
public class CustomerController {

    private static int id = 0;
    private static CustomerController instance;
    private CustomerMarketplace customerMarketplace;

    private CustomerController() {

        try {

            // Lookup for remote CustomerMarketplace object from the registry
            customerMarketplace = (CustomerMarketplace) Naming.lookup("CustomerMarketplaceServer");

        } catch (Exception e) {

            System.out.println("Exception occurred while Remote Object Lookup");
            e.printStackTrace();
        }
    }

    public static CustomerController getInstanceOf(){
        if(instance == null)
            instance = new CustomerController();
        return instance;
    }

    /**
     * Performing basic null check validation and invoking
     * the registrationService function of the remote
     * object as required
     *
     * @param name
     * @param username
     * @param password
     * @return response message
     */
    public String register(String name, String username, String password) {
        if(name!=null && username!=null && password!=null){

            CustomerDTO customerDTO = new CustomerDTO(String.valueOf(id++),name,username,password, "CUSTOMER");
            try {
                return customerMarketplace.registrationService(new Session(username), customerDTO);

            } catch (RemoteException e) {

                e.printStackTrace();
                return "Internal Server Error. Cannot Register You Now!";
            }
        }else
            return "Please Fill All the Required Fields!";

    }

    /**
     * Invoking addItemToCart on the remote object
     * to add products selected by the customers
     * in their respective cart.
     *
     * @param session
     * @param productID
     * @param quantity
     * @return boolean
     */
    public Object[] addItemsToCart(Session session, String productID, int quantity){

        try {
            return customerMarketplace.addItemToCart(session, productID, quantity);

        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Invoking removeItemsFromCart on the remote object
     * to remove products selected by the customers
     * from their respective cart.
     *
     * @param session
     * @param productID
     * @param quantity
     * @return
     */
    public Object[] removeItemsFromCart(Session session, String productID, int quantity){

        try {
            return customerMarketplace.removeItemFromCart(session, productID, quantity);

        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Invoking the purchaseItems on the remote object
     * to all the customer to purchase all the items
     * currently present in the cart.
     *
     * @param session
     * @return
     */
    public Object[] purchaseItems(Session session){

        try {
            return customerMarketplace.purchaseItems(session);

        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
