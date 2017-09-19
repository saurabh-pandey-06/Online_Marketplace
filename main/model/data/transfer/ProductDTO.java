package transfer;

import java.io.Serializable;

/**
 * ProductDTO helps in communicating and manipulating
 * product specific data within the underlying
 * storage mechanism. ProductDTO is a simple POJO class
 * having getter and setter methods.
 *
 * @author Saurabh
 * @version 1.0
 */
public class ProductDTO implements Serializable {

    // Product attributes
    private String id,name,type,description;
    private int quantity;
    private double price;

    public ProductDTO(){}

    public ProductDTO(String id, String name, String type, String description, int quantity, double price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    // getter & setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
