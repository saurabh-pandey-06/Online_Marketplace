package logic;

import authorize.Session;
import transfer.ProductDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 * Marketplace interface declares functionalities
 * that are common to all types of users. It
 * extends the Remote class of java.rmi package.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface Marketplace extends Remote {

    //Common Marketplace methods
    Session authenticationService(String username, String password) throws RemoteException;
    Collection<ProductDTO> browseItems() throws RemoteException;
}
