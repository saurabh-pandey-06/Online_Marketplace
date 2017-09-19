package entry;

import java.util.Scanner;

/**
 * Marketplace View implements a console based UI for
 * different users to interact with the system.
 *
 * @author Saurabh
 * @version 2.0
 */
public class MarketplaceView {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //TODO find a location for this.
        // Java RMI Security Manager
        System.setSecurityManager(new SecurityManager());

        try {
            System.out.println("Please Enter Your Choice! \n Press 1 For Login \n Press 2 For Registering as a Customer");

            int choice = s.nextInt();
            System.out.println("Choice Entered: " + choice);

            if (choice == 1) {
                CommonMarketplace.getInstanceOf().invokeLogin();

            } else
                // TODO Call registration function
                System.out.println("Please Contact An Administrator For Registering! ");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
    }
}
