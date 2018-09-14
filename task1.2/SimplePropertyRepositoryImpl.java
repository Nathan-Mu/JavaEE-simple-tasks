/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Exercise 1A Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Dongyu Zhao 27356094 
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository 
{
    //declare attribute
    private List<Property> properties = new ArrayList<>();

    //constructor
    public SimplePropertyRepositoryImpl() {
    }

    //add a property 
    @Override
    public void addProperty(Property property) throws Exception {
        //validate if the property exist
        if ((!properties.contains(property)) && (searchPropertyById(property.getId()) == null)) {
            properties.add(property);
        } else {
            throw new Exception("Property exists");
        }
    }
    
    //search the property by id
    @Override
    public Property searchPropertyById(int id) {
        for (Property property : properties) {
            if (property.getId() == id) {
                return property;
            }
        }
        return null;
    }
    
    //get all properties
    @Override
    public List<Property> getAllProperties() {
        return properties;
    }
}
