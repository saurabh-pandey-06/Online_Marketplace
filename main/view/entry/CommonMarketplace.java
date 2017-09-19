package entry;

import common.Controller;

import java.util.Scanner;

/**
 * CommonMarketplace class is a helper class to the MarketplaceView.
 * It contains the functionality common to both customers
 * and administrators thus enhancing reusability.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CommonMarketplace {

    private Scanner sc = new Scanner(System.in);
    private static CommonMarketplace commonMarketplace;

    private CommonMarketplace(){}

    public static CommonMarketplace getInstanceOf(){
        if(commonMarketplace == null)
            commonMarketplace = new CommonMarketplace();
        return commonMarketplace;
    }
    /**
     * Prompting user to input the login credentials and
     * calling the Login method of the BaseController.
     *
     */
    public void invokeLogin(){

        System.out.println("Please Enter Your Username and Password!");
        String username = sc.next();
        String password = sc.next();
        System.out.println("Username: "+username+ "\t & \t Password: *****");

        if(Controller.getInstanceOf().validateCredentials(username,password) == false || FrontController.getInstanceOf().authenticateUser(username,password) == false){
            System.out.println("Invalid Login Credentials!");
            invokeLogin();
        }
    }
}
