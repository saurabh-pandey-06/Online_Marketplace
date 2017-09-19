package access;

import com.mysql.jdbc.Statement;
import storage.DatabaseConnector;
import transfer.ProductDTO;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * ProductDAOImpl implements the ProductDAO interface. It
 * provides an implementation for all the functions of
 * the interface.
 *
 * @author Saurabh
 * @version 1.0
 */
public class ProductDAOImpl implements ProductDAO,Serializable {

    // Hash Map mocks the persistent storage system
    //private java.util.Map<String, ProductDTO> products = new HashMap<>();
    private static ProductDAOImpl instance;
    private String query;
    Statement stmt;
    ResultSet rs;

    /*
     * Constructor for the ProductDAOImpl class.
     * Creates runtime product objects
     * and puts them in the Array list
     */
    private ProductDAOImpl(){

        DatabaseConnector databaseConnector = new DatabaseConnector();
        stmt = databaseConnector.getStatement();
    }

    public static ProductDAOImpl getInstanceOf() {
        if(instance == null) {
            instance = new ProductDAOImpl();
        }
        return  instance;
    }

    // Method to fetch all products within the system
    @Override
    public Collection<ProductDTO> getAllProducts() {
       // return new ArrayList(products.values());
       java.util.Map<String, ProductDTO> products = new HashMap<>();
       query = "SELECT * FROM Product";
        try {
            rs = stmt.executeQuery(query);

            while (rs.next())  {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String type = rs.getString("Type");
                String description = rs.getString("Description");
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("Price");
                ProductDTO productDTO = new ProductDTO(id, name, type, description, quantity, price);
                products.put(id,productDTO);
            }

            return new ArrayList(products.values());
        } catch (SQLException e) {
            System.err.println("Unable execute query!");
            e.printStackTrace();
        }
        return null;
    }

    // Method to fetch a particular product within the system
    @Override
    public ProductDTO getProduct(String productID) {
        //return products.get(productID);
        query = "SELECT * FROM Product WHERE ID = '"+productID+"'";
        try {
            rs = stmt.executeQuery(query);
            if(rs.next()){
                
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String type = rs.getString("Type");
                String desc = rs.getString("Description");
                int quantity = rs.getInt("Quantity");
                double price = rs.getFloat("Price");
                return new ProductDTO(id, name, type, desc, quantity, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    // Method to add a product in the system
    @Override
    public String addProduct(ProductDTO product) {
        String message = "Product Added Successfully!";

        synchronized (this){
            ProductDTO existingProduct = getProduct(product.getId());
            if(existingProduct == null) {
                query = "INSERT into Product VALUES ('"+product.getId()+"','"+product.getName()+"','"+product.getType()+"','"+product.getDescription()+"',"+product.getQuantity()+","+product.getPrice()+")";

                try {
                    stmt.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else
                message = "Duplicate Product!";

            return message;
        }
    }

    // Method to update particular product within the system
    @Override
    public String updateProduct(String productID, String property, String value) {
        ProductDTO existingProduct = getProduct(productID);

        if(existingProduct != null) {
            double newValue = 0;

            if(property.equals("Quantity"))
                newValue = Integer.parseInt(value);
            else if(property.equals("Price"))
                newValue = Float.parseFloat(value);

            if (property.equals("Description"))
                query = "UPDATE Product SET " + property + " = '" + value + "' WHERE ID = '" + productID + "'";
            else
                query = "UPDATE Product SET " + property + " = " + newValue + " WHERE ID = '" + productID + "'";

            try {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "Product Updated Successfully!";
        }
        else
            return  "Product Not Found!";
    }

    // Method to delete a product from the system
    @Override
    public synchronized String deleteProduct(String productID) {
        ProductDTO existingProduct = getProduct(productID);

        if (existingProduct != null) {

            query = "DELETE from Product WHERE ID = '" + productID + "'";

            try {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "Product Deleted Successfully!";
        }
        else
            return  "Product Not Found!";
    }
}
