// Dongyu Zhao 27356094
package fit5042.tutex.calculator;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.Remote;

@Remote
public interface ComparePropertySessionBeanRemote {

    void addPropertyID(int propertID);

    int bestPerRoom();

    void removePropertyID(int propertyID);

    ComparePropertySessionBeanRemote create() throws CreateException, RemoteException;
    
}
