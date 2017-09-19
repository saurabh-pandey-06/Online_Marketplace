package common;

/**
 * The Controller helps in basic validation of user login credentials.
 * It is invoked before the front controller to avoid unnecessary
 * remote method invocations.
 *
 * @author Saurabh
 * @version 1.0
 */
public class Controller {

    private static Controller controller;

    //  Singleton pattern to avoid unnecessary object creation.
    private Controller(){}

    public static Controller getInstanceOf(){
        if(controller == null)
            controller = new Controller();
        return controller;
    }

    /**
     * Performing basic validations (null checks)
     * on the user input login credentials.
     *
     * @param username
     * @param password
     * @return boolean
     */
    public boolean validateCredentials(String username, String password) {

        if (username == null || password == null) {
            return false;
        } else
            return true;
    }
}
