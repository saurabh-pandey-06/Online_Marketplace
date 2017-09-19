package logic;

import access.*;
import authorize.Session;
import transfer.CartDTO;
import transfer.ProductDTO;
import transfer.UserDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

/**
 * MarketplaceImpl provides implementation logic for
 * Marketplace interface. It holds the business logic
 * for functionalities common to all types of users.
 *
 * @author Saurabh
 * @version 1.0
 */
public class MarketplaceImpl extends UnicastRemoteObject implements Marketplace {

    private UserDAO userDAO;
    private ProductDAO productDAO;

    /*
     * Constructor for MarketplaceImpl class.
     * Instantiating the Admin DAO And Customer DAO.
     * Calls the constructor of UnicastRemoteObject.
     *
     * @throws RemoteException
     */
    public MarketplaceImpl() throws RemoteException {
        super();

        //TODO do this for amindao as well
        userDAO = UserDAOImpl.getInstanceOf();
        productDAO = ProductDAOImpl.getInstanceOf();

    }

    /**
     * Provides the implementation logic for logging in to the system.
     *
     * @param username
     * @param password
     * @return String
     * @throws RemoteException
     */
    @Override
    public Session authenticationService(String username, String password) throws RemoteException {

        // Authenticating the User
        UserDTO userDTO = userDAO.getUser(username);

        if (userDTO != null && userDTO.getPassword().equals(password)){
	    System.out.println("Creating Session");
            Session session = new Session(username);
	    System.out.println("Role: "+session.userDTO.getRole());

            if(session.userDTO.getRole().equals("CUSTOMER")){
	       //System.out.println("Calling attach cart");
               session.userDTO = new CartDAOImpl().attachCart(session.userDTO.getUsername());
	    }

            return session;
        }

        else {
            System.out.println("User not found");
            return null; // TODO Throw Exception

        }
    }

    /**
     * Provides implementation for browsing the items.
     *
     * @return Products array
     * @throws RemoteException
     */
    @Override
    public Collection<ProductDTO> browseItems() throws RemoteException {

        return productDAO.getAllProducts();
    }
}
