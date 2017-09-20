package user;

import authorize.Session;
import logic.AdminMarketplace;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * AdminController is specifically concerned with the
 * functionalities associated with the administrator.
 *
 * @author Saurabh
 * @version 2.0
 */
public class AdminController {

    private AdminMarketplace adminMarketplace;
    private static AdminController instance;

    private AdminController() {

        try {

            // Lookup for remote AdminMarketplace object from the registry
            adminMarketplace = (AdminMarketplace) Naming.lookup("AdminMarketplaceServer");

        } catch (Exception e) {

            System.out.println("Exception occurred while Remote Object Lookup");
            e.printStackTrace();
        }
    }

    public static AdminController getInstanceOf(){
        if(instance == null)
            instance = new AdminController();
        return instance;
    }

    /**
     * Invoking the addItemsInSystem on the remote object
     * of the administrator to add a particular product
     * into the system.
     *
     * @param session
     * @param id
     * @param name
     * @param type
     * @param description
     * @param quantity
     * @param price
     * @return String
     */
    public String addItems(Session session, String id, String name, String type, String description, int quantity, double price){

        try {
            return adminMarketplace.addItemsInSystem(session, id, name, type, description, quantity, price);

        } catch (RemoteException e) {
            e.printStackTrace();
            return "Communication Error!";
        }
    }

    /**
     * Invoking the removeItemsInSystem on the remote object
     * of the administrator to remove a particular product
     * into the system.
     *
     * @param session
     * @param productID
     * @return
     */
    public String removeItems(Session session, String productID){

        try {
            return adminMarketplace.removeItemsFromSystem(session, productID);

        } catch (RemoteException e) {
            e.printStackTrace();
            return "Communication Error!";
        }
    }

    /**
     * Invoking the updateItemsInSystem on the remote object
     * of the administrator to update a particular product
     * into the system.
     *
     * @param session
     * @param productID
     * @param property
     * @param value
     * @return
     */
    public String updateItems(Session session, String productID, int property, String value){

        try {
            return adminMarketplace.updateItemsInSystem(session, productID, property, value);

        } catch (RemoteException e) {
            e.printStackTrace();
            return "Communication Error!";
        }
    }
}
