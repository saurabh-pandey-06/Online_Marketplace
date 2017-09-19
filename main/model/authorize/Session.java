package authorize;

import access.UserDAOImpl;
import transfer.UserDTO;

import java.io.Serializable;

/**
 * The Session is an object that holds the userDTO
 * object and maintains it throughout the user's
 * interaction with the system.
 *
 * @author Saurabh
 * @version 1.0
 */
public class Session implements Serializable {
    private static final long serialVersionUID = -6745473220581903527L;
    public UserDTO userDTO;

    public Session(String username){

        userDTO = UserDAOImpl.getInstanceOf().getUser(username);
    }
}