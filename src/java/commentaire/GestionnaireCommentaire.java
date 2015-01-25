/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commentaire;

import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateur.entities.Users;

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
    public Comment creerCommentaire(String commentaire, Users utilisateur){
            Comment c = new Comment(commentaire);
            c.setCommented_date((new Date()));
            c.setCommentepar(utilisateur);
            em.persist(c);
            return c;
    }
    public Collection<Comment> getAllCommentaire(){
        Query q = em.createQuery("select u from Comment u");  
        return q.getResultList();  
    }
}
