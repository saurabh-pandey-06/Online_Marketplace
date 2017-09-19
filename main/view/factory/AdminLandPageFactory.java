package factory;

import authorize.Session;
import menu.AdminMenu;

/**
 * AdminLandPageFactory is a factory that provides
 * functionalities specific to the administrators'.
 *
 * @author Saurabh
 * @version 1.0
 */
public class AdminLandPageFactory implements UserLandPageFactory {
    private Session session;

    public AdminLandPageFactory(Session session){
        this.session = session;
    }

    /**
     * Invoking the show function to display the administration functionality menu
     */
    @Override
    public void execute() {

        new AdminMenu().show(session);
    }
}
