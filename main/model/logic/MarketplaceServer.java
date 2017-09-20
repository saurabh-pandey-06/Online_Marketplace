package logic;

import authorize.AuthorizationInvocationHandler;

import java.lang.reflect.Proxy;
import java.rmi.Naming;

/**
 * Marketplace Server registers remote objects with
 * unique names in the Java RMI registry.
 *
 * @author Saurabh
 * @version 1.0
 */
public class MarketplaceServer {

    public static void main(String args[]) {
        // Java RMI Security Manager
        System.setSecurityManager(new SecurityManager());

        try{
            System.out.println("Creating a Marketplace Server!");

			/*
			 * This is the host where we are running the Marketplace server.
			 * Three remote objects are registered:
			 * MarketplaceServer - Providing functionalities common to all users.
			 * CustomerMarketplaceServer - Providing customer specific functionalities.
			 * AdminMarketplaceServer - Providing administrator specific functionalities.
			 */
            String marketplaceServer = "MarketplaceServer";
            String customerMarketplaceServer = "CustomerMarketplaceServer";
            String adminMarketplaceServer = "AdminMarketplaceServer";

            /*
             * Creating new instance of a Marketplace, Customer Marketplace
             * and Administrator Marketplace each. Dynamic Proxy pattern is
             * used for creating the Customer Marketplace and Administrator
             * Marketplace objects.
             */

            MarketplaceImpl marketplace = new MarketplaceImpl();
            CustomerMarketplace customerMarketplace = (CustomerMarketplace)
                    Proxy.newProxyInstance(CustomerMarketplace.class.getClassLoader(),
                    new Class<?>[] {CustomerMarketplace.class},
                    new AuthorizationInvocationHandler(new CustomerMarketplaceImpl()));
            AdminMarketplace adminMarketplace = (AdminMarketplace)
                    Proxy.newProxyInstance(AdminMarketplace.class.getClassLoader(),
                    new Class<?>[] {AdminMarketplace.class},
                    new AuthorizationInvocationHandler(new AdminMarketplaceImpl()));

            System.out.println("MarketplaceServer: binding it to name: " + marketplaceServer);
            System.out.println("CustomerMarketplaceServer: binding it to name: " + customerMarketplaceServer);
            System.out.println("AdminMarketplaceServer: binding it to name: " + adminMarketplaceServer);

            // Binding of the newly created instances to the RMI Lookup.
            Naming.rebind(marketplaceServer, marketplace);
            Naming.rebind(customerMarketplaceServer, customerMarketplace);
            Naming.rebind(adminMarketplaceServer, adminMarketplace);

            System.out.println("Marketplace Server Ready!");
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }
}
