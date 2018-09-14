package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * TODO Implement this. For this Week, you will need to use the Container managed
 * method instead of the Application Managed method done in earlier weeks.
 * 
 * Please refer to provided materials to complete this class.
 * @author Dongyu Zhao
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    //annotation: entity manager
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void addProperty(Property property) throws Exception {
        // add a new property
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        //search a property by id
        Property property = entityManager.find(Property.class, id);
        property.getTags().size();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        // get all properties
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public List<ContactPerson> getAllContactPeople() throws Exception {
        // get all contact persons
        return entityManager.createNamedQuery(ContactPerson.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        // remove a property 
        if (searchPropertyById(propertyId) != null) {
            entityManager.remove(searchPropertyById(propertyId));
        }
    }

    @Override
    public void editProperty(Property property) throws Exception {
        // update a property
        entityManager.merge(property);
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> cQuery = builder.createQuery(Property.class);
        Root<Property> p = cQuery.from(Property.class);
        Predicate condition = builder.le(p.get("price"), budget);
        
        cQuery.where(condition);
        TypedQuery<Property> q = entityManager.createQuery(cQuery);
        List<Property> result = q.getResultList();
        
        return result;
    }

    @Override
    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception {
        contactPerson = entityManager.find(ContactPerson.class, contactPerson.getConactPersonId());
        contactPerson.getProperties().size();
        entityManager.refresh(contactPerson);

        return contactPerson.getProperties();
    }

 
}
