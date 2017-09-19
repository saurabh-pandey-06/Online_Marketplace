package factory;

/**
 * AdminLandPage helps in displaying the administrator specific
 * landing page by using the administrator's factory function.
 *
 * @author Saurabh
 * @version 1.0
 */
public class AdminLandPage extends LandPage {
    private UserLandPageFactory userLandPageFactory;

    public AdminLandPage(UserLandPageFactory userLandPageFactory) {
        this.userLandPageFactory = userLandPageFactory;
    }

    /**
     * Invoking the administrator specific display function
     * through the UserLandPageFactory abstraction layer.
     */
    @Override
    protected void displayPage() {

        userLandPageFactory.execute();
    }
}
