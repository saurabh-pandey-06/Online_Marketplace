package menu;

import authorize.Session;
import common.BaseController;
import transfer.ProductDTO;
import user.CustomerController;

import java.util.Collection;
import java.util.Scanner;

/**
 * CustomerMenu Class helps in the displaying the
 * functionalities specific to the customer.
 *
 * @author Saurabh
 * @version 1.0
 */
public class CustomerMenu {
    private Scanner s = new Scanner(System.in);
    private BaseController baseController = BaseController.getInstanceOf();
    private CustomerController customerController = CustomerController.getInstanceOf();

    /**
     * Displays the Functionality Menu for the administrator
     * and invokes a function on test class to check the
     * authorization of the Customer
     */
    public void show(Session session) {
        try {
            int cont = 1;
            CustomerController customerController = CustomerController.getInstanceOf();

            System.out.println("Welcome: " + session.userDTO.getName());
            do {

                System.out.println("Menu Options: \n 1. Browse Item \n 2. Add Item To Cart  \n 3. Remove Item From Cart \n 4. Purchase Item \n 5. Exit \n Please select an option to continue.");
                String choice = s.next();

                switch (choice) {
                    case "1":
                        System.out.println("Product Details: ");
                        Collection<ProductDTO> products = baseController.browseItems();
                        for (ProductDTO p :
                                products) {
                            System.out.println("Name: " + p.getName() + " \t\t ID: " + p.getId() + " \t\t Type: " + p.getType() + " \t\t Description: " + p.getDescription() + " \t\t Quantity Available: " + p.getQuantity() + " \t\t Price: $" + p.getPrice());
                        }

                        break;

                    case "2":
                        System.out.println("Please Enter The Product ID: ");
                        String id = s.next();
                        System.out.println("Please Enter Quantity: ");
                        int quantity = s.nextInt();

                        Object o[] = customerController.addItemsToCart(session, id, quantity);
                        String response = (String) o[0];
                        System.out.println(response);
                        session = (Session) o[1];

                        break;

                    case "3":
                        System.out.println("Please Enter The Product ID: ");
                        String productID = s.next();
                        System.out.println("Please Enter Quantity: ");
                        int quantity_in = s.nextInt();

                        o = customerController.removeItemsFromCart(session, productID, quantity_in);
                        response = (String) o[0];
                        System.out.println(response);
                        session = (Session) o[1];

                        break;

                    case "4":
                        o = customerController.purchaseItems(session);
                        double price = (Double) o[0];
                        System.out.println("Total Purchase Price: $" + price);
                        session = (Session) o[1];

                        break;

                    case "5":
                        cont = 0;
                        break;

                    default:
                        System.out.println("Invalid Input! Please Enter A Valid Input!");

                }
            } while (cont == 1);

        } catch (Exception e) {
            System.out.println("Exception Caught");
            e.printStackTrace();
        }
    }
}
