/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import article.entities.Article;
import article.entities.GestionnairesArticle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import utilisateur.entities.GestionnairesUtilisateur;
import utilisateur.entities.Users;

/**
 *
 * @author Justin
 */
@Stateless
@Path("article.entities.article")
public class ArticleFacadeREST extends AbstractFacade<Article> {
    @EJB
    private GestionnairesArticle gestionnairesArticle;
    @EJB
    GestionnairesUtilisateur gu;

    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    public ArticleFacadeREST() {
        super(Article.class);
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Article entity, @HeaderParam(value = "Users") String use) {
        System.out.print(use);
        //for (int i = 0 ; i.)
        Collection<Users> temp = gu.checkUser(use);
        Iterator i = temp.iterator();
        Users usetmp;
        while(i.hasNext()){
             usetmp = (Users) i.next();
              Article art1 = gestionnairesArticle.creerArticle(entity.getTitle(), entity.getKeyword(), entity.getContent(),usetmp);
        }
       
        //super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Article entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        System.out.println("test del");
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Article find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Article> findAll() {

        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Article> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void persist1(Object object) {
        em.persist(object);
    }
    
    
}
