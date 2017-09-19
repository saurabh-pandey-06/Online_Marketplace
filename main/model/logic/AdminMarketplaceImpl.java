package logic;

import access.AdminDAO;
import access.AdminDAOImpl;
import access.ProductDAO;
import access.ProductDAOImpl;
import authorize.Session;
import transfer.ProductDTO;
import transfer.UserDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * AdminMarketplaceImpl provides implementation logic for
 * AdminrMarketplace interface. It holds the business logic
 * for functionalities that are specific to the administrators.
 *
 * @author Saurabh
 * @version 1.0
 */
public class AdminMarketplaceImpl extends UnicastRemoteObject implements AdminMarketplace {

    private AdminDAO adminDAO;

    public AdminMarketplaceImpl() throws RemoteException {
        super();
        adminDAO = AdminDAOImpl.getInstanceOf();
    }

    /**
     * Provides the logic for adding products to marketplace.
     *
     * @return boolean
     */
    @Override
    public String addItemsInSystem(Session session, String id, String name, String type, String description, int quantity, double price) {

        ProductDTO productDTO= new ProductDTO();
        productDTO.setId(id);
        productDTO.setName(name);
        productDTO.setType(type);
        productDTO.setDescription(description);
        productDTO.setQuantity(quantity);
        productDTO.setPrice(price);

        return ProductDAOImpl.getInstanceOf().addProduct(productDTO);

    }

    /**
     * Provides the logic for removing products from marketplace
     *
     * @param productID
     * @return boolean
     */
    @Override
    public String removeItemsFromSystem(Session session, String productID) {

        return ProductDAOImpl.getInstanceOf().deleteProduct(productID);
    }

    /**
     * Provides the logic for updating products in marketplace
     *
     * @param session
     * @return boolean
     */
    @Override
    public String updateItemsInSystem(Session session, String productID, int property, String value) {
        String p = null;

        synchronized (this){
            ProductDAO productDAO = ProductDAOImpl.getInstanceOf();
            ProductDTO productDTO = productDAO.getProduct(productID);
            if(productDTO != null){
                if(property == 1)
                    p = "Description";
                if(property == 2)
                    p = "Quantity";
                if(property == 3)
                    p = "Price";
                return productDAO.updateProduct(productID, p, value);
            }else
                return "Product Not Found!";
        }
    }

    /**
     * Provides the logic for adding-removing users from marketplace
     *
     * @param userDTO
     * @return boolean
     */
    @Override
    public boolean manipulateUsersInSystem(Session session, UserDTO userDTO) {

        System.out.println(" ### Contact An Administrator For Manipulating Users In System! ### ");
        return false;
    }
}
