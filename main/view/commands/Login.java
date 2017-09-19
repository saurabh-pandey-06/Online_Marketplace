package commands;

import authorize.Session;
import common.BaseController;

/**
 * The Login command executes the login functionality of the system.
 * It implements the command interface to provide a concrete
 * definition to the login function by invoking the base controller.
 *
 * @author Saurabh
 * @version 1.0
 */
public class Login implements Command {
    private String username, password, role;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Invoking the Base Controller that would help in authenticating
     * the user through remote method invocation.
     *
     * @return
     */
    @Override
    public Session execute() {

        return BaseController.getInstanceOf().login(username, password);

    }
}
