/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commentaire;

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
public class GestionnaireCommentaire {
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public Commentaire creerArticle(int idart, int idaut, String commentaire){
            Commentaire c = new Commentaire(idart,idaut,commentaire);
            em.persist(c);
            return c;
    }
    public void creerCommentaireTest(){
            creerArticle(1,1,"ceci est un commentaire");
    }
    public Collection<Commentaire> getAllCommentaire(){
        Query q = em.createQuery("select u from Commentaire u");  
        return q.getResultList();  
    }
}
