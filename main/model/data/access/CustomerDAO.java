package access;

import transfer.CustomerDTO;

import java.util.Collection;

/**
 * AdminDAO interface declares functions that help in
 * manipulating data specific to the administrators.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface CustomerDAO {

    public Collection<CustomerDTO> getAllCustomers();
    public CustomerDTO getCustomer(String username);
    public boolean addCustomer(CustomerDTO customer);
    public boolean updateCustomer(CustomerDTO customer);
    public boolean deleteCustomer(String username);
}
