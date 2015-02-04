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
  
    public Users creeUtilisateur(String nom, String prenom, String login, String password) {  
        Users u = new Users(nom, prenom, login,password);  
        em.persist(u);  
        return u;  
    }  
    
    public Collection<Users> checkUser(String login){
        System.out.println("Login :" + login);
         Query q = em.createQuery("select u from Users u where u.username =:login");
        q.setParameter("login", login); 
        System.out.println("Requete :" + q.getResultList());
        return q.getResultList();
    }
    
     public Boolean checkUser(String login, String password){
        System.out.println("Login :" + login);
         Query q = em.createQuery("select u from Users u where u.username =:login and u.password =:password");
        q.setParameter("password", password);
        q.setParameter("login", login); 
        if (q.getResultList().isEmpty()) {
            System.out.println("Utilisateur inconnu");
            return false;
        } else {
            System.out.println("Utilisateur connu... OK!");
            return true;
        }
    }
  
    public Collection<Users> getAllUsers() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");  
        return q.getResultList();  
    }  
    
}
