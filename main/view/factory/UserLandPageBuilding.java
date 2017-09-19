package factory;

import authorize.Session;

/**
 * UserLandPageBuilding extends the LandPageBuilding abstract class
 * It helps in providing concrete implementation for displaying the
 * user specific landing pages.
 *
 * @author Saurabh
 * @version 1.0
 */
public class UserLandPageBuilding extends LandPageBuilding {

    /**
     * Creates and helps in displaying user specific landing pages.
     *
     * @param session
     */
    @Override
    public void displayLandPage(Session session) {
        UserLandPageFactory userLandPageFactory;

        if(session.userDTO.getRole().equals("CUSTOMER")){
            userLandPageFactory = new CustomerLandPageFactory(session);
            new CustomerLandPage(userLandPageFactory).displayPage();

        }else if(session.userDTO.getRole().equals("ADMIN")){
            userLandPageFactory = new AdminLandPageFactory(session);
            new AdminLandPage(userLandPageFactory).displayPage();

        }
    }
}
