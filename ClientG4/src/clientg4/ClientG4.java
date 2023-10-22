/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientg4;

import dao.IDao;
import entities.Machine;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lachgar
 */
public class ClientG4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://10.10.20.150:1099/dao");
       
            dao.create(new Machine("S23", "HP", 2000));
            dao.create(new Machine("S63", "LENOVO", 3000));
            dao.create(new Machine("S83", "HP", 2000));
            for (Machine m : dao.findAll()) {
                System.out.println(m);
            }
        
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientG4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientG4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientG4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
