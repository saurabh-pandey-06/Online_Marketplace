package factory;

import authorize.Session;

/**
 * LandPageBuilding is an abstract factory that
 * provides an abstraction layer for
 * displaying any user specific landing page.
 *
 * @author Saurabh
 * @version 1.0
 */
public abstract class LandPageBuilding {

    public abstract void displayLandPage(Session session);
}
