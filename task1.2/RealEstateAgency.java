package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * TODO Exercise 1A Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Dongyu Zhao 27356094
 */
public class RealEstateAgency {
    //declare attribute
    private String name;
    private final PropertyRepository propertyRepository;
    
    //constructor
    public RealEstateAgency (String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    //craete properties by default
    public void createProperties() {
        try {
            propertyRepository.addProperty(new Property(1, "1 Deshao St, Clayton VIC 3168, Australia", 6, 323, new BigDecimal("124515")));
            propertyRepository.addProperty(new Property(2, "11 Bond St,  Clayton VIC 3168, Australia", 3, 352, new BigDecimal("984762")));
            propertyRepository.addProperty(new Property(3, "11 Lodel St, Glen Huntly VIC 3163, Australia", 3, 677, new BigDecimal("887765")));
            propertyRepository.addProperty(new Property(4, "22 Pocost St, Glen Huntly VIC 3163, Australia", 4, 378, new BigDecimal("1086566")));
            propertyRepository.addProperty(new Property(5, "33 River St, Clayton VIC 3168, Australia", 7, 776, new BigDecimal("1342232")));
            System.out.println("5 properties added successfully");
        } catch (Exception ex) {
            System.out.println("Failed to create properties: " + ex.getMessage());
        }
    }
    
    //main method
    public static void main(String[] args) {
        try {
            //create a real estate agency with assigned name and run the program
            new RealEstateAgency("Monash Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }
    
    //run the program
    public void run() {
        //create default properties
        createProperties();
        System.out.println("===================================================================");
        //show all properties
        displayAllProperties();
        System.out.println("===================================================================");
        //ask user to search property
        searchPropertyById();
    }
    
    //display all properties
    public void displayAllProperties() {
        try {
            for (Property p: propertyRepository.getAllProperties()) {
                if (p != null) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception ex) {
            System.out.println("Failed to display all properties: " + ex.getMessage());
        }
    }
    
    //search property by id
    public void searchPropertyById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the property you want to search: ");
        try {
            //ask for user input
            String input = scanner.next();
            //validate user input
            if (isNumeric(input)) {
                Property property = propertyRepository.searchPropertyById(Integer.valueOf(input));
                if (property != null) {
                    System.out.println(property.toString());
                } else {
                    System.out.println("Fail to search the property: property not found");
                }
            } else {
                //the user input must be a number
                System.out.println("Fail to search the property: invalid input");
            }
        } catch (Exception ex) {
            System.out.println("Failed to search the property: " + ex.getMessage());
        }
        
    }
    
    //return true when the string only contains number
    public static boolean isNumeric(String string) {
        return string.matches("[0-9]+");
    }
}
