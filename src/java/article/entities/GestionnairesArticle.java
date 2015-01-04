/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package article.entities;

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
public class GestionnairesArticle {
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Article creerArticle(String titre, String keyword, String article){
            Article a = new Article(titre,keyword,article);
            em.persist(a);
            return a;
    }
    public void creerArticleTest(){
            creerArticle("ceci est un titre","ceci est un motclef","ceci est un article");
    }
    public Collection<Article> getAllArticle(){
        Query q = em.createQuery("select u from Article u");  
        return q.getResultList();  
    }
}
