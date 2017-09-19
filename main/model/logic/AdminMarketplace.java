package logic;

import authorize.RequiresRole;
import authorize.Session;
import transfer.ProductDTO;
import transfer.UserDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * AdminMarketplace interface declares functionalities
 * that are specific to the administrators. It extends
 * the Remote class of java.rmi package.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface AdminMarketplace extends Remote {

    // Administrator specific Marketplace functions.
    @RequiresRole("ADMIN")
    String addItemsInSystem(Session session, String id, String name, String type, String description, int quantity, double price) throws RemoteException;

    @RequiresRole("ADMIN")
    String removeItemsFromSystem(Session session, String productID) throws RemoteException;

    @RequiresRole("ADMIN")
    String updateItemsInSystem(Session session, String productID, int property, String value) throws RemoteException;

    @RequiresRole("ADMIN")
    boolean manipulateUsersInSystem(Session session, UserDTO userDTO) throws RemoteException;

}
