/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveurg4;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author Lachgar
 */
public class ServeurG4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IDao<Machine> dao = new  MachineService();
            IDao<Salle> salledao = new  SalleService();
            
            LocateRegistry.createRegistry(1099);
            
            Naming.bind("rmi://localhost:1099/dao", dao);
            Naming.bind("rmi://localhost:1099/salledao", salledao);
            
            
            
            System.out.println("En attente des clients");
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(ServeurG4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServeurG4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServeurG4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
