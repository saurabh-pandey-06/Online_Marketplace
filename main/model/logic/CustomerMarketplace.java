package logic;

import authorize.RequiresRole;
import authorize.Session;
import transfer.CustomerDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * CustomerMarketplace interface declares functionalities
 * that are specific to the customers. It extends the
 * Remote class of java.rmi package.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface CustomerMarketplace extends Remote{

    // Customer specific Marketplace functions.
    @RequiresRole("CUSTOMER")
    String registrationService(Session session, CustomerDTO customerDTO) throws RemoteException;

    @RequiresRole("CUSTOMER")
    Object[] addItemToCart(Session session, String productID, int quantity) throws RemoteException;

    @RequiresRole("CUSTOMER")
    Object[] removeItemFromCart(Session session, String productID, int quantity) throws RemoteException;

    @RequiresRole("CUSTOMER")
    Object[] purchaseItems(Session session) throws RemoteException;
}
