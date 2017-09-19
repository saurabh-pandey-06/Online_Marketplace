package access;

import transfer.AdminDTO;

import java.util.Collection;

/**
 * AdminDAO interface declares functions that help in
 * manipulating data specific to the administrators.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface AdminDAO {

    public Collection<AdminDTO> getAllAdmins();
    public AdminDTO getAdmin(String username);
    public boolean addAdmin(AdminDTO admin);
    public boolean updateAdmin(AdminDTO admin);
    public boolean deleteAdmin(String username);
}
