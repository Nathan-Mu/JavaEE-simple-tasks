/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * TODO Step 1 Complete this class.
 * 
 * This class will implement the Property Repository.
 * 
 * This class is completed with a Application Managed persistence.
 * 
 * Normally in a JEE application, there are two ways, application managed will
 * be used this week, container managed will be used later during the semester.
 * 
 * Please refer Lecture 3 Demo files in order to complete this task.
 * 
 * @author Dongyu Zhao 27356094
 */
public class JPAPropertyRepositoryImpl implements PropertyRepository {
    //declare persistence unit
    private static final String PERSISTENCE_UNIT = "W3AExeStudentPU";
    
    //declare entity manager and entity manager factory
    private EntityManager em;
    private EntityManagerFactory emFactory;
    
    // constructor
    public JPAPropertyRepositoryImpl() {
        this.emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        this.em = this.emFactory.createEntityManager();
    }
    
    // implement abstract method (add property)
    @Override
    public void addProperty(Property property) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            // add a new property
            em.persist(property);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
            transaction.rollback();
            }
        }
    }
    
    // implement abstract method (search property)
    @Override
    public Property searchPropertyById(int propertyId) throws Exception {
        // find a property by primary key
        return em.find(Property.class, propertyId);
    }

    // implement abstract method (get all properties)
    @Override
    public List<Property> getAllProperties() throws Exception {
        // find all properties
        return em.createNamedQuery(Property.FIND_ALL).getResultList();
    }

    // implement abstract method (remove a property)
    @Override
    public void removeProperty(int propertyId) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            // remove a property by primary key
            em.remove(em.find(Property.class, propertyId));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    // implement abstract method (edit property)
    @Override
    public void editProperty(Property property) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            // update the property
            em.merge(property);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    // close entity manager
    @Override
    public void close() {
        em.close();
    }
}
