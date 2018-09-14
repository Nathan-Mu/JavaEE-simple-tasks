package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * TODO Step 0 You will need to introduce the annotation "Entity" at this class.
 * 
 * There are multiple correct ways of doing this. At the end of the day,
 * you can choose whichever way you find to be easier for you.
 * 
 * Please note that persistence unit has NOT BEEN included in this starter file.
 * @author Eddie Leung
 */

// add entity annotation 
@Entity
// add named queries annotation
@NamedQueries({@NamedQuery(name = Property.FIND_ALL, query = "SELECT p FROM Property p")})
public class Property implements Serializable {

    public static final String FIND_ALL = "Property.findAll";
    
    //A number that is used to uniquely identify a property
    private int propertyId;
    //The full address of a property
    private String address;
    //The number of bedroom a property has
    private int numberOfBedrooms;
    //The size of the property
    private double size;
    //How much the property costs
    private double price;

    /**
     * Default constructor
     */
    public Property() {
        this.propertyId = 0;
        this.address = "Unknown";
        this.numberOfBedrooms = 0;
        this.size = 0;
        this.price = 0;
    }
    
    /**
     * Copy constructor
     */
    public Property(Property property) {
        this.propertyId = property.propertyId;
        this.address = property.address;
        this.numberOfBedrooms = property.numberOfBedrooms;
        this.size = property.size;
        this.price = property.price;
    }

    /**
     * Parameterized constructor
     *
     * @param propertyId - initialize the attribute propertyId to this value
     * @param address - initialize the attribute address to this value
     * @param numberOfBedrooms - initialize the attribute numberOfBedrooms to this value
     * @param size - initialize the attribute size to this value
     * @param price - initialize the attribute price to this value
     */
    public Property(int propertyId, String address, int numberOfBedrooms, double size, double price) {
        this.propertyId = propertyId;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.size = size;
        this.price = price;
    }

    /**
     * @return the value of attribute propertyId
     */
    // add id annotation (primary key)
    @Id
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * Change the value of attribute propertyId to a new value
     *
     * @param propertyId - the new value of attribute propertyId
     */
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * @return the value of attribute address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Change the value of attribute address to a new value
     *
     * @param address - the new value of attribute address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the value of attribute numberOfBedrooms
     */
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Change the value of attribute numberOfBedrooms to a new value
     *
     * @param numberOfBedrooms - the new value of attribute numberOfBedrooms
     */
    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    /**
     * @return the value of attribute size
     */
    public double getSize() {
        return size;
    }

    /**
     * Change the value of attribute size to a new value
     *
     * @param size - the new value of attribute size
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * @return the value of attribute price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Change the value of attribute price to a new value
     *
     * @param price - the new value of attribute price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return a string representation of the property object
     */
    @Override
    public String toString() {
        return propertyId + " " + address + " " + numberOfBedrooms + "BR(s) " + size + "sqm " + NumberFormat.getCurrencyInstance().format(price);
    }
}
