// Dongyu Zhao 27356094
package fit5042.tutex.calculator;

import fit5042.tutex.repository.entities.Property;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.CreateException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// stateful means the app can record the action done before
@Stateful
public class ComparePropertySessionBean implements ComparePropertySessionBeanRemote {

    ArrayList<Integer> list;
    
    @PersistenceContext
    private EntityManager entityManager;
    

    @Override
    public void addPropertyID(int propertyID) {
        list.add(propertyID);
    }

    @Override
    public void removePropertyID(int propertyID) {
        list.remove(new Integer(propertyID));
    }    

    @Override
    public int bestPerRoom() {
        Integer bestID=0;
        Property P;
        int numberOfRooms;
        double price;
        double bestPerRoom=100000000.00;
        for(Integer propertyID : list)
        {
            P=entityManager.find(Property.class, propertyID);
            numberOfRooms=P.getNumberOfBedrooms();
            price=P.getPrice();
            if(price/numberOfRooms<bestPerRoom)
            {
                bestPerRoom=price/numberOfRooms;
                bestID=P.getPropertyId();
            }
        }
        return bestID;
    }

    @PostConstruct
    public void init() {
        list = new ArrayList<>();
    }

    public ComparePropertySessionBeanRemote create() throws CreateException, RemoteException {
        return null;
    }

    public void ejbCreate() throws CreateException {
    }

    
    
}
