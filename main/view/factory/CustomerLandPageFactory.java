package factory;

import authorize.Session;
import menu.CustomerMenu;

/**
 * CustomerLandPageFactory is a factory that provides
 * functionalities specific to the customers'.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CustomerLandPageFactory implements UserLandPageFactory {
    private Session session;

    public CustomerLandPageFactory(Session session) {
        this.session = session;
    }

    /**
     * Invoking the show function to display the customer functionality menu
     */
    @Override
    public void execute() {
        new CustomerMenu().show(session);
    }
}
