package menu;

import authorize.Session;
import common.BaseController;
import transfer.ProductDTO;
import user.AdminController;

import java.util.Collection;
import java.util.Scanner;

/**
 * AdminMenu Class helps in the displaying the
 * functionalities specific to the administrator.
 *
 * @author Saurabh
 * @version 2.0
 */
public class AdminMenu {

    private Scanner s = new Scanner(System.in);
    private BaseController baseController = BaseController.getInstanceOf();

    /**
     * Displays the Functionality Menu for the administrator
     * and invokes a function on test class to check the
     * authorization of the Admin
     *
     */
    public void show(Session session) {
        try{
            int cont = 1;

            System.out.println("Welcome: "+session.userDTO.getName());
            do{

                System.out.println("Menu Options: \n 1. Browse Item \n 2. Add Item In System \n 3. Remove Item From System \n 4. Update Item In System \n 5. Exit \n Please select an option to continue.");
                String choice = s.next();

                switch (choice){
                    case "1":
                        System.out.println("Product Details: ");
                        Collection<ProductDTO> products = baseController.browseItems();
                        for ( ProductDTO p :
                                products) {
                            System.out.println("Name: "+p.getName()+" \t\t ID: "+p.getId()+" \t\t Type: "+p.getType()+" \t\t Description: "+p.getDescription()+" \t\t Quantity Available: "+p.getQuantity()+" \t\t Price: $"+p.getPrice());
                        }
                        break;

                    case "2":
                        System.out.println("Please Enter The Product Details: \n Enter ProductID: ");
                        String id = s.next();
                        System.out.println("Enter Product Name: ");
                        String name = s.next();
                        System.out.println("Enter Product Type: ");
                        String type = s.next();
                        System.out.println("Enter Product Description: ");
                        String description = s.next();
                        System.out.println("Enter Product Quantity: ");
                        int quantity = s.nextInt();
                        System.out.println("Enter Product Price: ");
                        double price = s.nextDouble();

                        System.out.println(AdminController.getInstanceOf().addItems(session, id, name, type, description, quantity, price));
                        break;

                    case "3":
                        System.out.println("Please Enter The Product Details: \n Enter ProductID:");
                        String productID = s.next();
                        System.out.println(AdminController.getInstanceOf().removeItems(session, productID));
                        break;

                    case "4":
                        System.out.println("Please Enter The Product Details: \n Enter ProductID:");
                        productID = s.next();
                        System.out.println("Please Select An Option To Update A Product Property: \n 1. Description \n 2. Quantity \n 3. Price");
                        int property = s.nextInt();
                        if(property < 1 ||property > 3){
                            System.out.println("Invalid Property Selected!");
                            break;
                        }
                        System.out.println("Please Enter The New Value For The Product Property:");
                        String value = s.next();
                        System.out.println(AdminController.getInstanceOf().updateItems(session, productID, property, value));
                        break;

                    case "5":
                        cont = 0;
                        break;

                    default:
                        System.out.println("Invalid Input! Please Enter A Valid Input!");

                }
            }while(cont == 1);

        } catch (Exception e) {
            System.out.println("Input Exception: System Terminates");

        }
    }
}
