/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author pc
 */
@Entity
@NamedQuery(name = "findAllSalles", query = "from Machine")
@NamedNativeQuery(name = "findAllSalleNztive", query = "select * from salle", resultClass = Salle.class)
public class Salle implements Serializable {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code  ;
    
    @OneToMany(mappedBy = "salle" , fetch= FetchType.EAGER)
    private List<Machine> listMachine;

    public Salle() {
    }

    public Salle(String code) {
        this.code = code;
    }

    public Salle(String code, List<Machine> listMachine) {
        this.code = code;
        this.listMachine = listMachine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Machine> getListMachine() {
        return listMachine;
    }

    public void setListMachine(List<Machine> listMachine) {
        this.listMachine = listMachine;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", code=" + code + ", listMachine=" + listMachine + '}';
    }
    
    


    
}
