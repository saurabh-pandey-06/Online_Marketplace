package access;


import transfer.ProductDTO;

import java.util.Collection;

/**
 * ProductDAO interface declares functions that help in
 * manipulating Product related data with the system.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface ProductDAO {

    public Collection<ProductDTO> getAllProducts();
    public ProductDTO getProduct(String productID);
    public String addProduct(ProductDTO product);
    public String updateProduct(String productID, String property, String value);
    public String deleteProduct(String productID);
}