package authorize;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * The Authorization Invocation Handler checks the authorization rights
 * of a user to access a function within the system. It compares the role
 * of the user with the role associated with each function through the
 * RequiresRole annotation. It implements InvocationHandler and Serializable
 * interfaces.
 *
 * @author Saurabh
 * @version 1.0
 */
public class AuthorizationInvocationHandler implements InvocationHandler, Serializable {
    private static final long serialVersionUID = 6925780928377938176L;
    private Object objectImpl;

    public AuthorizationInvocationHandler(Object impl) {
        this.objectImpl = impl;
    }

    /**
     * Invokes a function requested by the user. I authorization
     * is required it checks for the user role for authorization.
     * Once authorized, it invokes the requested function.
     * If user is unauthorized, a custom exception is thrown.
     *
     * @param proxy
     * @param method
     * @param args
     * @return Object
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{

        if (method.isAnnotationPresent(RequiresRole.class)) {
            RequiresRole test = method.getAnnotation(RequiresRole.class);
            Session session = (Session) args[0];

            if (session.userDTO.getRole().equals(test.value())) {
                return method.invoke(objectImpl, args);
            } else {
                throw new AuthorizationException(method.getName(), session.userDTO.getRole());
            }
        } else {
            return method.invoke(objectImpl, args);
        }


    }
}