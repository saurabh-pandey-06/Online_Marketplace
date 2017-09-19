package authorize;

/**
 * AuthorizationException is a custom exception class for handling
 * authorization exceptions and printing a standard message. It
 * extends the RuntimeException class.
 *
 * @author Saurabh
 * @version 1.0
 */
public class AuthorizationException extends RuntimeException {
    private static final long serialVersionUID = 5528415690278423524L;

    /**
     * Constructor displaying a customized message for the user.
     * @param methodName
     */
    public AuthorizationException(String methodName, String role) {
        super("Invalid Authorization - "+role+" does not have access to " + methodName + "() function!");
    }
}
