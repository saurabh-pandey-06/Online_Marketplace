package common;

import authorize.Session;
import logic.Marketplace;
import transfer.ProductDTO;

import java.rmi.Naming;
import java.util.Collection;

/**
 * BaseController acts a link between the model and the view.
 * Here, it acts an RMI client class.
 *
 * @author Saurabh
 * @version 3.0
 */
public class BaseController {

    private Marketplace marketplace;
    private static BaseController baseController;

    // Singleton pattern to avoid unnecessary object creation.
    private BaseController(){

        try{
            // Lookup for remote Marketplace object from the registry
            marketplace = (Marketplace) Naming.lookup("//in-csci-rrpc01.cs.iupui.edu:5000/MarketplaceServer");
        }catch(Exception e){
            System.out.println("Exception occurred while Remote Object Lookup:");
            e.printStackTrace();
        }
    }

    public static BaseController getInstanceOf(){
        if(baseController == null)
            baseController = new BaseController();
        return baseController;
    }

    /**
     * Invoking authenticationService function on the
     * remote object marketplace to authenticate the user.
     *
     * @param username
     * @param password
     * @return name of user
     */
    public Session login(String username, String password) {
        try {
            return marketplace.authenticationService(username, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Invoking browseItems function on the
     * remote object marketplace to display
     * all the products available in the system.
     *
     * @return collection of items
     */
    public Collection<ProductDTO> browseItems() {
        try {
            return marketplace.browseItems();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
