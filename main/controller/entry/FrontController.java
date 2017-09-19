package entry;

import authorize.Session;
import commands.Login;
import commands.UserRequest;

/**
 * The Front Controller is the single entry point into the system.
 * It authenticates the user login credentials. If authenticated,
 * it invokes the dispatcher to display the corresponding landing
 * page.
 *
 * @author Saurabh
 * @version 1.0
 */
public class FrontController {
    private Dispatcher dispatcher;
    private static FrontController frontController;

    // Singleton pattern to avoid unnecessary object creation.
    private FrontController() {}

    public static FrontController getInstanceOf() {
        if (frontController == null)
            frontController = new FrontController();
        return frontController;
    }

    /**
     * Authenticating the user by validating the login credentials.
     * Invokes the Login command for validation.
     *
     * @param username
     * @param password
     * @return boolean
     */
    public boolean authenticateUser(String username, String password) {

        Login loginCommand = new Login(username, password);
        Session session = new UserRequest(loginCommand).executeCommand();
        if(session != null){
            dispatchRequest(session);
            return true;
        } else
            return false;
    }

    /**
     * Tracking the page requested by the user.
     *
     * @param request
     */
    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    /**
     * Invoking the dispatcher to display
     * the user landing page
     *
     * @param session
     */
    private void dispatchRequest(Session session) {
        //log each request
        trackRequest(session.userDTO.getRole());

        dispatcher = new Dispatcher();
        dispatcher.dispatch(session);
    }
}
