package access;

import transfer.UserDTO;

import java.util.Collection;

/**
 * UserDAOImpl class provides concrete implementation
 * for the functionalities defined in the UserDAO
 * interface
 *
 * @author Saurabh
 * @version 1.0
 */
public class UserDAOImpl implements UserDAO {
    private CustomerDAOImpl customerDAO;
    private AdminDAOImpl adminDAO;
    private static UserDAOImpl instance;

    // Singleton pattern to restrict to single object creation
    private UserDAOImpl(){

        customerDAO = CustomerDAOImpl.getInstanceOf();
        adminDAO = AdminDAOImpl.getInstanceOf();
    }

    public static UserDAOImpl getInstanceOf() {
        if(instance == null) {
          instance = new UserDAOImpl();
        }
     return  instance;
    }

    /**
     * Returns all the user in the system.
     *
     * @return UserDTO
     */
    // TODO Implementation
    @Override
    public Collection<UserDTO> getAllUsers() {
        return null;
    }

    /**
     * Returns the User object having the provided username
     *
     * @param username
     * @return
     */
    @Override
    public UserDTO getUser(String username) {
        UserDTO userDTO = customerDAO.getCustomer(username);
        if(userDTO == null)
            userDTO = adminDAO.getAdmin(username);
        return userDTO;
    }

    /**
     * Adds the given user into the system.
     *
     * @param userDTO
     * @return boolean
     */
    // TODO Implementation
    @Override
    public boolean addUser(UserDTO userDTO) {
        return false;
    }

    /**
     * Updates the given user in the system
     * @param userDTO
     * @return boolean
     */
    // TODO Implementation
    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }

    /**
     * Deletes the given user from the system
     *
     * @param username
     * @return
     */
    // TODO Implementation
    @Override
    public boolean deleteUser(String username) {
        return false;
    }
}
