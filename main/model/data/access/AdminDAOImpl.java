package access;

import com.mysql.jdbc.Statement;
import storage.DatabaseConnector;
import transfer.AdminDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * AdminDAOImpl implements the AdminDAO interface. It
 * provides an implementation for all the functions of
 * the interface.
 *
 * @author Saurabh
 * @version 1.0
 */
public class AdminDAOImpl implements AdminDAO {

    // Hash Map mocks the persistent storage system
    private Map<String, AdminDTO> admins = new HashMap<>();
    private static AdminDAOImpl instance;
    private String query;
    Statement stmt;
    ResultSet rs;

    /*
     * Constructor for the AdminDAOImpl class.
     * Creates runtime administrator objects
     * and puts them in the hash map
     */
    private AdminDAOImpl(){

        /*AdminDTO admin1 = new AdminDTO("A1", "Saurabh", "Saurabh.06", "Pandey","ADMIN");
        AdminDTO admin2 = new AdminDTO("A2", "Devpriya", "Devpriya.12", "Dave","ADMIN");

        admins.put(admin1.getUsername(),admin1);
        admins.put(admin2.getUsername(),admin2);*/
        DatabaseConnector databaseConnector = new DatabaseConnector();
        stmt = databaseConnector.getStatement();
    }

    public static AdminDAOImpl getInstanceOf() {
        if (instance == null)
            instance = new AdminDAOImpl();
        return instance;
    }

    // Method to fetch records of all administrators
    @Override
    public Collection<AdminDTO> getAllAdmins() {
        return admins.values();
        //query = "SELECT * FROM USER WHERE ROLE = 'ADMIN'";
        //rs = stmt.executeQuery(query);
    }

    // Method to fetch record of a particular administrator
    @Override
    public AdminDTO getAdmin(String username) {
        //return admins.get(username);
        query = "SELECT * FROM User WHERE ROLE = 'ADMIN' AND USERNAME = '"+username+"'";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                String uname = rs.getString("USERNAME");
                String pwd = rs.getString("PASSWORD");
                String role = rs.getString("ROLE");
                return new AdminDTO(id, name, uname, pwd, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    // Method to add an administrator in the system
    @Override
    public boolean addAdmin(AdminDTO admin) {
        AdminDTO existingAdmin = getAdmin(admin.getUsername());

        if(existingAdmin == null) {
            query = "INSERT into User VALUES ('"+admin.getId()+"','"+admin.getName()+"','"+admin.getUsername()+"','"+admin.getPassword()+"','"+admin.getRole()+"')";

            try {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;

        }else
            return false;
    }

    // Method to update record of a particular administrator
    @Override
    public boolean updateAdmin(AdminDTO admin) {
        return true;//TODO REMOVE
    }

    // Method to delete an administrator from the system
    @Override
    public boolean deleteAdmin(String username) {
        AdminDTO existingAdmin = getAdmin(username);

        if(existingAdmin != null) {

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
