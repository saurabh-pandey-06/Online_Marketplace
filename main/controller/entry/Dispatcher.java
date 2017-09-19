package entry;

import authorize.Session;
import factory.LandPageBuilding;
import factory.UserLandPageBuilding;

/**
 * The Dispatcher helps in displaying the landing page
 * specific to a particular type of user by using the
 * Landing Page Abstract Factory.
 *
 * @author Saurabh
 * @version 1.0
 */
public class Dispatcher {
    private LandPageBuilding landPageBuilding;

    public Dispatcher(){
        landPageBuilding = new UserLandPageBuilding();

    }

    /**
     * Invoking the display function of the Abstract
     * Factory Class LandPageBuilding.
     *
     * @param session
     */
    public void dispatch(Session session){

        landPageBuilding.displayLandPage(session);
    }
}
