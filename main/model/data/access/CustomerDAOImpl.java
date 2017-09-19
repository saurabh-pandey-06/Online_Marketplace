package access;

import com.mysql.jdbc.Statement;
import storage.DatabaseConnector;
import transfer.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * CustomerDAOImpl implements the CustomerDAO interface. It
 * provides an implementation for all the functions of
 * the interface.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CustomerDAOImpl implements CustomerDAO{

    // Hash map to mock persistent storage mechanism
    private Map<String, CustomerDTO> customers = new HashMap<>();
    private static CustomerDAOImpl instance;
    private String query;
    Statement stmt;
    ResultSet rs;

    /*
     * Constructor for the CustomerDAOImpl class.
     * Creates runtime customer objects
     * and puts them in the hash map
     */
    private CustomerDAOImpl(){

        /*CustomerDTO customer1 = new CustomerDTO("C1", "Yash", "Yash.12", "Pandey", "CUSTOMER");
        CustomerDTO customer2 = new CustomerDTO("C2", "Raunak", "Raunak.23", "Pathak","CUSTOMER");

        customers.put(customer1.getUsername(),customer1);
        customers.put(customer2.getUsername(),customer2);*/
        DatabaseConnector databaseConnector = new DatabaseConnector();
        stmt = databaseConnector.getStatement();
    }

    public static CustomerDAOImpl getInstanceOf(){
        if(instance == null)
            instance = new CustomerDAOImpl();
        return instance;
    }

    // Method to fetch records of all customers
    @Override
    public Collection<CustomerDTO> getAllCustomers() {
        return customers.values();
    }

    // Method to fetch record of a particular customer
    @Override
    public CustomerDTO getCustomer(String username) {
        //return customers.get(username);
        query = "SELECT * FROM User WHERE ROLE = 'CUSTOMER' AND USERNAME = '"+username+"'";

        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                String uname = rs.getString("USERNAME");
                String pwd = rs.getString("PASSWORD");
                String role = rs.getString("ROLE");
                return new CustomerDTO(id, name, uname, pwd, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    // Method to add a customer in the system
    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        CustomerDTO existingCustomer = getCustomer(customerDTO.getUsername());

        if(existingCustomer == null) {
            query = "INSERT into User VALUES ('"+customerDTO.getId()+"','"+customerDTO.getName()+"','"+customerDTO.getUsername()+"','"+customerDTO.getPassword()+"','"+customerDTO.getRole()+"')";

            try {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;

        }else
            return false;
    }

    // Method to update record of a particular customer
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
            return true;//TODO REMOVE
    }

    // Method to delete a customer from the system
    @Override
    public boolean deleteCustomer(String username) {
        CustomerDTO existingCustomer = getCustomer(username);

        if(existingCustomer != null) {

            query = "DELETE from User WHERE Username = '" + username + "'";

            try {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        }else
            return false;

    }
}
