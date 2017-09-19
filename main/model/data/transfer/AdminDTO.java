package transfer;

import java.io.Serializable;

/**
 * AdminDTO helps in communicating and manipulating
 * administrator specific data within the underlying
 * storage mechanism. AdminDTO is a simple POJO class
 * that extends UserDTO.
 *
 * @author Saurabh
 * @version 1.0
 */
public class AdminDTO extends UserDTO implements Serializable {

    public AdminDTO(){}

    public AdminDTO(String id,String name, String username, String password, String role){

        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
