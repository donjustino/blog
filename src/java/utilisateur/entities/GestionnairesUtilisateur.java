/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateur.entities;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Justin
 */
@Stateless
public class GestionnairesUtilisateur {
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void creerUtilisateursDeTest() {  
        creeUtilisateur("John", "Lennon", "jlennon","test");  
        creeUtilisateur("Paul", "Mac Cartney", "pmc","test");  
        creeUtilisateur("Ringo", "Starr", "rstarr","test");  
        creeUtilisateur("Georges", "Harisson", "georgesH","test");  
    }  
  
    public Utilisateur creeUtilisateur(String nom, String prenom, String login, String password) {  
        Utilisateur u = new Utilisateur(nom, prenom, login,password);  
        em.persist(u);  
        return u;  
    }  
  
    public Collection<Utilisateur> getAllUsers() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");  
        return q.getResultList();  
    }  
    
}
