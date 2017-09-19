package transfer;

import java.io.Serializable;

/**
 * UserDTO helps in communicating and manipulating
 * user specific data within the underlying
 * storage mechanism. UserDTO is a simple POJO class
 * having getter and setter methods.
 *
 * @author Saurabh
 * @version 1.0
 */
public class UserDTO implements Serializable{

    // User attributes
    protected String id,name,username,password,role;

    // getter and setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
