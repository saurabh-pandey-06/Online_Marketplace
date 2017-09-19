package access;

import transfer.UserDTO;

import java.util.Collection;

/**
 * CustomerDAO interface declares functions that help in
 * manipulating data specific to the customers.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface UserDAO {

    public Collection<UserDTO> getAllUsers();
    public UserDTO getUser(String username);
    public boolean addUser(UserDTO userDTO);
    public boolean updateUser(UserDTO userDTO);
    public boolean deleteUser(String username);
}