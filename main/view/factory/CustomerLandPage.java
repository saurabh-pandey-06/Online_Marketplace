package factory;

/**
 * CustomerLandPage helps in displaying the customer specific
 * landing page by using the customer's factory function.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CustomerLandPage extends LandPage {
    private UserLandPageFactory userLandPageFactory;

    public CustomerLandPage(UserLandPageFactory userLandPageFactory) {
        this.userLandPageFactory = userLandPageFactory;
    }

    /**
     * Invoking the customer specific display function
     * through the UserLandPageFactory abstraction layer.
     */
    @Override
    protected void displayPage() {
        userLandPageFactory.execute();
    }
}
